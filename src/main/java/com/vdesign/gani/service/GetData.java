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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
    private BlockingQueue queue = new LinkedBlockingQueue();

    public ProdList getProdList() {
//        int processors = Runtime.getRuntime().availableProcessors();
//        ExecutorService executorService = Executors.newFixedThreadPool(processors * 2);

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


    class TaskProduct implements Runnable {
        @Override
        public void run() {
            ResponseEntity<RespProduct> productResponseEntity = restTemplate.getForEntity(PRODUCT_INFO, RespProduct.class);
            if (productResponseEntity.getStatusCodeValue() == 200) {

            } else if (productResponseEntity.getStatusCodeValue() == 401) {

            }
        }
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
