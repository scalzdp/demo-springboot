package com.example.demo.configure;

//import org.apache.http.client.utils.HttpClientUtils;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class RestTemplateConfig {

    @Bean
//    @LoadBalanced//LoadBalanced 开启负载均衡，(如果是名称的远程要开启，不然要关闭)
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
//        return new RestTemplate();
        RestTemplate restTemplate = new RestTemplate(factory);
        //定位原因：通过走读代码。
        //原因：RestTemplate在处理String的时候默认编码是ISO_8859_1，但是这种编码格式对中文会出现乱码。
        //解决方案：通过重新向RestTemplate中加入StringHTTPMessageConverter为UTF-8的编码格式。
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }
}
