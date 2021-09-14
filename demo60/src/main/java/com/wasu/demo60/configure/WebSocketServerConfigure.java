package com.wasu.demo60.configure;

import com.wasu.demo60.handler.MyStringWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @ClassName:WebSocketServerConfigure
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/14 9:41
 */
@Configuration
@EnableWebSocket
public class WebSocketServerConfigure implements WebSocketConfigurer {
    @Autowired
    private MyStringWebSocketHandler myStringWebSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myStringWebSocketHandler,"/connect").withSockJS();
    }
}
