package com.wasu.demo42.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @ClassName:KafkaMessageListener
 * @Description: 消息消费
 * @Author: Syl
 * @Date: 2021/8/18 16:09
 */
@Component
public class KafkaMessageListener {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = "test",groupId = "test-consumer")
    public void listen(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition){
        //@Header注解来获取当前消息来自哪个分区
        logger.info("接收消息: {},partition：{}", message,partition);
    }
}
