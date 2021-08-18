package com.wasu.demo42.domain;

import org.apache.kafka.common.protocol.types.Field;

import java.io.Serializable;

/**
 * @ClassName:Message
 * @Description: 消息实体
 * @Author: Syl
 * @Date: 2021/8/18 16:40
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 3827854467281773860L;
    private String from;
    private String message;

    public Message(){

    }

    public Message(String from, String message) {
        this.from = from;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
