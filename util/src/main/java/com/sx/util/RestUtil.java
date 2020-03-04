package com.sx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author : Anui
 * @date : 2020/3/4
 * @time : 17:35
 * @Description :
 */

public class RestUtil {
    static Logger log = LoggerFactory.getLogger(RestUtil.class);

    /**
     * 发送post请求
     *
     * @param restTemplate
     * @param url
     * @param param
     * @param <T>
     * @return
     */
    public static <T> T postJSON(RestTemplate restTemplate, String url, Object param, Class<T> responseType){

        HttpEntity<String> formEntity = makePostJSONEntity(param);
        T result = restTemplate.postForObject(url, formEntity, responseType);
        log.info("rest-post-jason 响应信息：{}", JsonUtil.toJson(result));
        return result;
    }

    /**
     * 生成JSON形式的请求头
     *
     * @param param
     * @return
     */
    private static HttpEntity<String> makePostJSONEntity(Object param) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept",MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> formEntity = new HttpEntity<String>(JsonUtil.toJson(param), headers);log.info("rest-post-json-请求参数:{}", formEntity.toString());
        return formEntity;
    }

    /**
     * 生成Get请求内容
     *
     * @param param
     * @param excludes
     * @return
     */
    public static String makeGetParamContent(Map<String, ?extends Object> param, String... excludes){

        StringBuilder content = new StringBuilder();
        List<String> excludeKeys = Arrays.asList(excludes);
        param.forEach((key, v) ->{
            content.append(key).append("=").append(v).append("&");
        });
        if(content.length() > 0){
            content.deleteCharAt(content.length() - 1);
        }
        return content.toString();
    }
}
