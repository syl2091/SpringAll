package com.wasu.demo57.config;

import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.web.client.RestTemplate; /**
 * @ClassName:ConsumerConfigure
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/7 16:24
 */
@Configuration
public class ConsumerConfigure {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
