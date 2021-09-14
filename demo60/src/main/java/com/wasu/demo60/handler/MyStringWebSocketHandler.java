package com.wasu.demo60.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @ClassName:MyStringWebSocketHandler
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/14 9:23
 */
@Component
public class MyStringWebSocketHandler extends TextWebSocketHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("和客户端建立连接");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        session.close(CloseStatus.SERVER_ERROR);
        log.error("连接异常", exception);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("和客户端断开连接");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //获取客户端发来的消息
        String s = message.getPayload();
        log.info(s);
        //发送消息给客户端
        session.sendMessage(new TextMessage(fakeAi(s)));
        //关闭连接
        //session.close(CloseStatus.NORMAL);
    }

    private static String fakeAi(String s) {
        if (s == null || "".equals(s)){
            return "你说什么,我没听清";
        }
        return s.replace('你','我')
                .replace("吗","")
                .replace('?','!')
                .replace('？','！');
    }
}
