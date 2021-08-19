package com.wasu.demo45.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName:TestController
 * @Description: 可以看到WebFlux默认使用的是Netty服务器：
 * @Author: Syl
 * @Date: 2021/8/19 15:17
 */
@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("sync")
    public String sync(){
        logger.info("sync method start");
        String result = this.execute();
        logger.info("sync method end");
        return result;
    }

    @GetMapping("async/mono")
    public Mono<String> asyncMono(){
        logger.info("async method start");
        Mono<String> result = Mono.fromSupplier(this::execute);
        logger.info("async method end");
        return result;
    }

    private String execute() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }


    /**
     * 返回值类型为Flux的时候，它是一个数据流，不是一次性数据包，
     * 服务端会不断地（假如Flux数据长度大于1）往客户端发送数据。
     * 这时，客户端不会关闭连接，会一直等着服务器发过来的新的数据流。
     * 这种模式称为Server-Sent Events。
     * @return
     */
    @GetMapping(value = "/async/flux",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> asyncFlux(){
        logger.info("async method start");
        Flux<String> result = Flux.fromStream(IntStream.range(1,6).mapToObj(i->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "int value"+i;
        }));
        logger.info("async method end");
        return result;
    }

}
