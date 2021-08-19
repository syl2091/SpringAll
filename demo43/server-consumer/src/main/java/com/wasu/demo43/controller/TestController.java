package com.wasu.demo43.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName:TestControlelr
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/19 10:40
 */
@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

   // private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private RestTemplate restTemplate;
    private static  final String SERVER_ID = "server-provider";

    @GetMapping("uri")
    public List<URI> getServerUris(){
        return discoveryClient.getInstances(SERVER_ID).stream().map(ServiceInstance::getUri)
                .collect(Collectors.toList());
    }

    @GetMapping("hello")
    public String hello(){
       // ServiceInstance serviceInstance = loadBalancerClient.choose(SERVER_ID);
        //String url = serviceInstance.getUri().toString() + "/hello";
        String url = "http://" + SERVER_ID + "/hello";
        logger.info("remote server url：{}",url);
        return restTemplate.getForObject(url, String.class);

    }
}
