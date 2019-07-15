package com.vdesign.gani.service;

import com.vdesign.gani.ProdList;
import com.vdesign.gani.domain.RespCase;
import com.vdesign.gani.domain.RespProduct;
import com.vdesign.gani.utils.JsonUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/8 15:20
 * @Version 1.0
 **/
@Service("GetData")
public class GetData {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String PRODUCT_LIST = "https://shopapp.gani.com.cn/smi/Gani_shop_webapi/getProductList";
    private static final String PRODUCT_INFO = "https://shopapp.gani.com.cn/smi/Gani_shop_webapi/getProductInfo";
    private static final String CASE_INFO = "https://shopapp.gani.com.cn/smi/Gani_shop_webapi/getCaseInfo";
    private static final String PIC_URL = "https://gani-file.oss-cn-shenzhen.aliyuncs.com/";
    private static final String PIC_PATH = "C:/pic/";


    public ProdList getProdList() {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("attrs", "");
        map.add("brand_id", "12");
        map.add("is_type", "");
        map.add("ranktype", "2");
        map.add("searchtxt", "");
        map.add("user_id", "6281");
        String jsonStr = post(map, PRODUCT_LIST);
        return JsonUtil.json2pojo(jsonStr, ProdList.class);
    }

    public RespProduct getProdInfo(String id) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("product_id", id);
        map.add("user_id", "6281");
        String jsonStr = ascii2native(post(map, PRODUCT_INFO));
        return JsonUtil.json2pojo(jsonStr, RespProduct.class);
    }


    public RespCase getCaseInfo(String id) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("case_id", id);
        map.add("user_id", "6281");
        String jsonStr = ascii2native(post(map, CASE_INFO));
        return JsonUtil.json2pojo(jsonStr, RespCase.class).setId(id);
    }


    public String post(MultiValueMap<String, Object> map, String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        ResponseEntity<String> listResponseEntity = restTemplate.postForEntity(url, request, String.class);
        return listResponseEntity.getBody();
    }


    public String getPic(String url) throws IOException {
        FileOutputStream fos = null;
        InputStream inputStream = null;
        String picName = url.replaceAll("/", "-");
        try {
            ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(PIC_URL + url, byte[].class);
            fos = new FileOutputStream(new File(PIC_PATH + picName));
            inputStream = new ByteArrayInputStream(responseEntity.getBody());
            int len = 0;
            byte[] buf = new byte[4096];
            while ((len = inputStream.read(buf, 0, 4096)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
        return picName;
    }


    public static String ascii2native(String asciicode) {

        String[] asciis = asciicode.split("\\\\u");
        StringBuilder nativeValue = new StringBuilder(asciis[0]);
        try {
            for (int i = 1; i < asciis.length; i++) {
                String code = asciis[i];
                nativeValue.append((char) Integer.parseInt(code.substring(0, 4), 16));
                if (code.length() > 4) {
                    nativeValue.append(code.substring(4, code.length()));
                }
            }
        } catch (NumberFormatException e) {
            return asciicode;
        }
        return nativeValue.toString();
    }
}
