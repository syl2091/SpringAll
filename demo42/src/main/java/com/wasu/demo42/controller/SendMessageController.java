package com.wasu.demo42.controller;

import com.wasu.demo42.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:SendMessageController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/18 14:33
 */
@RestController
public class SendMessageController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private KafkaTemplate<String,Message> kafkaTemplate;

    @GetMapping("/send/{message}")
    public void send(@PathVariable String message){
        //send方法是一个异步方法，我们可以通过回调的方式来确定消息是否发送成功
        ListenableFuture<SendResult<String,Message>> future = kafkaTemplate.send("test",new Message("syl",message));
        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.error("消息：{} 发送失败，原因：{}", message, throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Message> stringStringSendResult) {
                logger.info("成功发送消息：{}，offset=[{}]", message, stringStringSendResult.getRecordMetadata().offset());

            }
        });
    }
}
