package com.vdesign.gani;

import com.vdesign.gani.domain.RespCase;
import com.vdesign.gani.domain.entity.*;
import com.vdesign.gani.domain.repository.*;
import com.vdesign.gani.domain.RespProduct;
import com.vdesign.gani.service.GetData;
import com.vdesign.gani.utils.JsonUtil;
import com.vdesign.gani.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/10 11:49
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class GaniTest {

    private @Resource
    GetData getData;
    private @Resource
    RedisUtil redisUtil;
    private @Resource
    ProdCaseRepository prodCaseRepository;
    private @Resource
    AttrRepository attrRepository;
    private @Resource
    CaseAttrRepository caseAttrRepository;
    private @Resource
    CaseImgRepository caseImgRepository;
    private @Resource
    CaseRepository caseRepository;
    private @Resource
    ProdAttrRepository prodAttrRepository;
    private @Resource
    ProdImgRepository prodImgRepository;
    private @Resource
    ProductRepository productRepository;
    private @Resource
    SattrRepository sattrRepository;


    volatile List<RespProduct> products = new ArrayList<>();
    volatile List<RespCase> cases = new ArrayList<>();
    volatile Set<String> caseIds = new HashSet<>();
    Set<String> picUrls = new HashSet<>();

    /**
     * 获取gani数据
     */
    @Test
    public void test() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processors);
        ProdList prodList = getData.getProdList();
        Set<String> prodIds = prodList.getData().parallelStream().map(Prod::getId).collect(Collectors.toSet());

        for (String prodId : prodIds) {
            executorService.execute(() -> {
                RespProduct prodInfo = getData.getProdInfo(prodId);
                products.add(prodInfo);
                log.info("{} 查询商品详情：{}", Thread.currentThread().getName(), prodId);
                List<RespProduct.CaseData> caseData = prodInfo.getCaseData();
                if (caseData != null && caseData.size() > 0) {
                    for (RespProduct.CaseData caseDatum : caseData) {
                        String caseDatumId = caseDatum.getId();
                        boolean contains;
                        synchronized (this) {
                            contains = !caseIds.contains(caseDatumId);
                        }
                        if (contains) {
                            RespCase caseInfo = getData.getCaseInfo(caseDatumId);
                            synchronized (this) {
                                cases.add(caseInfo);
                                log.info("{} 查询case详情：{}", Thread.currentThread().getName(), caseDatumId);
                                caseIds.add(caseDatumId);
                            }
                        }
                    }
                }
            });


        }
        executorService.shutdown();

        while (true) {
            try {
                if (!!executorService.awaitTermination(1, TimeUnit.SECONDS)) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopWatch.stop();
        System.out.println("耗时：" + stopWatch.getTotalTimeSeconds());

        cases = cases.parallelStream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(RespCase::getId))), ArrayList::new));
        System.out.println(products.size());
        System.out.println(cases.size());
//        redisUtil.set("products", products);
//        redisUtil.set("cases", cases);

        List<Product> productList = new ArrayList<>();
        List<Case> caseList = new ArrayList<>();
        // prod->case对应关系
        Map<String, String> proCasePic = new HashMap<>();
        // 所有attr数据
        List<Attr> attrs = new ArrayList<>();
        // 所有sattr数据
        List<Sattr> sattrs = new ArrayList<>();
        // case 属性数据
        List<CaseAttr> caseAttrs = new ArrayList<>();
        int caseattrId = 1;
        // prod 属性数据
        List<ProdAttr> prodAttrs = new ArrayList<>();
        int prodAttrId = 1;
        // case imags 数据
        List<CaseImg> caseImages = new ArrayList<>();
        // prod imags 数据
        List<ProdImg> prodImgs = new ArrayList<>();
        for (RespProduct respProduct : products) {
            picUrls.add(respProduct.getProductPreview());
            Product product = new Product();
            BeanUtils.copyProperties(respProduct, product);
            product.setProductPreview(respProduct.getProductPreview());
            productList.add(product);
            List<RespProduct.CaseData> caseData = respProduct.getCaseData();
            if (caseData != null && caseData.size() > 0) {
                for (RespProduct.CaseData caseDatum : caseData) {
                    picUrls.add(caseDatum.getPreview());
                    proCasePic.put(respProduct.getId() + "-" + caseDatum.getId(), caseDatum.getPreview());
                }
            }
            List<RespProduct.ProductAttrData> productAttrData = respProduct.getProductAttrData();
            if (productAttrData != null && productAttrData.size() > 0) {
                for (RespProduct.ProductAttrData productAttrDatum : productAttrData) {
                    attrs.add(new Attr().setId(productAttrDatum.getId()).setAttrName(productAttrDatum.getProductAttrName()).setAttrType(productAttrDatum.getType()));
                    List<RespProduct.ProductAttrData.SattrData> sattrData = productAttrDatum.getSattrData();
                    if (sattrData != null && sattrData.size() > 0) {
                        for (RespProduct.ProductAttrData.SattrData sattrDatum : sattrData) {
                            sattrs.add(new Sattr().setId(sattrDatum.getId()).setAttrName(sattrDatum.getProductAttrName()).setPath(sattrDatum.getPath()));
                            ProdAttr prodAttr = new ProdAttr()
                                    .setId(prodAttrId++ + "")
                                    .setProdId(respProduct.getId())
                                    .setAttrId(productAttrDatum.getId())
                                    .setAttrName(productAttrDatum.getProductAttrName())
                                    .setSattrId(sattrDatum.getId())
                                    .setSattrName(sattrDatum.getProductAttrName())
                                    .setSPath(sattrDatum.getPath());
                            prodAttrs.add(prodAttr);
                        }
                    }
                }
            }

            List<RespProduct.ProductImg> productImgData = respProduct.getProductImgData();
            if (productImgData != null && productImgData.size() > 0) {
                prodImgs.addAll(productImgData.parallelStream().map(productImg -> {
                    ProdImg prodImg = new ProdImg()
                            .setId(productImg.getId())
                            .setProductId(productImg.getProductId())
                            .setGroupanme(productImg.getGroupanme())
                            .setPath(productImg.getPath())
                            .setSeq(productImg.getSeq())
                            .setUpdatetime(productImg.getUpdatetime());
                    prodImg.setSeq(productImg.getSeq());
                    return prodImg;
                }).collect(Collectors.toList()));
            }
        }

        for (RespCase respCase : cases) {
            picUrls.add(respCase.getHeadimg());
            Case aCase = new Case();
            BeanUtils.copyProperties(respCase, aCase);
            aCase.setHeadimg(respCase.getHeadimg());
            caseList.add(aCase);
            List<RespProduct> caseProducts = respCase.getProducts();
            if (caseProducts != null && caseProducts.size() > 0) {
                for (RespProduct caseProduct : caseProducts) {
                    String key = caseProduct.getId() + "-" + respCase.getId();
                    if (!proCasePic.containsKey(key)) {
                        proCasePic.put(key, "");
                    }
                }
            }

            List<RespCase.Attr> attrList = respCase.getAttr();
            if (attrList != null && attrList.size() > 0) {
                for (RespCase.Attr caseattr : attrList) {
                    Attr attr = new Attr();
                    BeanUtils.copyProperties(caseattr, attr);
                    attrs.add(attr);
                }
            }

            List<RespCase.CaseAttrData> caseAttrData = respCase.getCaseAttrData();
            if (caseAttrData != null && caseAttrData.size() > 0) {
                for (RespCase.CaseAttrData caseAttrDatum : caseAttrData) {
                    List<RespCase.CaseAttrData.SattrData> sattrData = caseAttrDatum.getSattrData();
                    if (sattrData != null && sattrData.size() > 0) {
                        for (RespCase.CaseAttrData.SattrData sattrDatum : sattrData) {
                            sattrs.add(new Sattr().setId(sattrDatum.getId()).setAttrName(sattrDatum.getAttrName()).setPath(""));
                            CaseAttr caseAttr = new CaseAttr()
                                    .setId(caseattrId++ + "")
                                    .setCaseId(respCase.getId())
                                    .setAttrId(caseAttrDatum.getId())
                                    .setAttrName(caseAttrDatum.getAttrName())
                                    .setSattrId(sattrDatum.getId())
                                    .setSattrName(sattrDatum.getAttrName());
                            caseAttrs.add(caseAttr);
                        }
                    }
                }
            }
            if (respCase.getId().equals("758")) {
                System.out.println();
            }
            List<RespCase.Img> imgs = respCase.getImgs();
            if (imgs != null && imgs.size() > 0) {
                for (RespCase.Img img : imgs) {
                    picUrls.add(img.getPath());
                    CaseImg caseImg = new CaseImg();
                    caseImg.setCaseId(respCase.getId());
                    BeanUtils.copyProperties(img, caseImg);
                    caseImg.setPath(img.getPath());
                    caseImages.add(caseImg);
                    List<String> productIdList = img.getProductList();
                    if (productIdList != null && productIdList.size() > 0) {
                        StringBuilder builder = new StringBuilder("");
                        for (String s : productIdList) {
                            builder.append(s).append(",");
                        }
                        caseImg.setProductIds(builder.substring(0, builder.length() - 1));
                    }
                    List<String> attrList1 = img.getAttrList();
                    if (attrList1 != null && attrList1.size() > 0) {
                        StringBuilder builder = new StringBuilder("");
                        for (String s : attrList1) {
                            if (StringUtils.isEmpty(s))
                                continue;
                            builder.append(s).append(",");
                        }
                        caseImg.setAttrIds(builder.substring(0, builder.length() - 1));
                    }
                }
            }
        }

        List<ProdCase> productCases = new ArrayList<>();
        int i = 1;
        for (String s : proCasePic.keySet()) {
            String[] split = s.split("-");
            productCases.add(new ProdCase().setProdId(split[0]).setCaseId(split[1]).setId(i++ + "").setCasePic(proCasePic.get(s)));
        }

        attrs = attrs.parallelStream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Attr::getId))), ArrayList::new));
        sattrs = sattrs.parallelStream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Sattr::getId))), ArrayList::new));

        attrRepository.deleteAll();
        caseRepository.deleteAll();
        caseAttrRepository.deleteAll();
        caseImgRepository.deleteAll();
        prodImgRepository.deleteAll();
        prodAttrRepository.deleteAll();
        productRepository.deleteAll();
        prodCaseRepository.deleteAll();
        sattrRepository.deleteAll();

        attrRepository.saveAll(attrs);
        caseRepository.saveAll(caseList);
        caseAttrRepository.saveAll(caseAttrs);
        caseImgRepository.saveAll(caseImages);
        prodAttrRepository.saveAll(prodAttrs);
        prodCaseRepository.saveAll(productCases);
        prodImgRepository.saveAll(prodImgs);
        productRepository.saveAll(productList);
        sattrRepository.saveAll(sattrs);


        // 下载图片

        /*for (String picUrl : picUrls) {
            if (StringUtils.isEmpty(picUrl))
                continue;
            try {
                log.info("获取图片数据：{}", picUrl);
                String pic = getData.getPic(picUrl);
                log.info("{}", pic);
            } catch (IOException e) {
                log.error("获取图片出错", e);
                e.printStackTrace();
            }
        }*/
    }


    @Test
    public void test3() {
        List<Product> all = productRepository.findAll();
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processors);
        for (Product product : all) {
            executorService.execute(() -> {
                try {
                    log.info("获取图片数据：{}", product.getProductPreview());
                    getData.getPic(product.getProductPreview());
                } catch (IOException e) {
                    log.error("下载图片异常", e);
                    e.printStackTrace();
                }
            });
        }
    }


    @Test
    public void test4() {
        List<RespCase> cases = (List<RespCase>) redisUtil.get("cases");
        Set<String> style = new HashSet<>();
        for (RespCase aCase : cases) {
            List<RespCase.CaseAttrData> caseAttrData = aCase.getCaseAttrData();
            if (caseAttrData != null && caseAttrData.size() > 0) {
                for (RespCase.CaseAttrData caseAttrDatum : caseAttrData) {
                    if ("风格".equals(caseAttrDatum.getAttrName())) {
                        style.addAll(caseAttrDatum.getSattrData().parallelStream().map(RespCase.CaseAttrData.SattrData::getAttrName).collect(Collectors.toSet()));
                    }
                }
            }
        }
        System.out.println();
    }

}
