package com.wasu.demo54.listener;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName:MyItemReaderListener
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/3 11:17
 */
@Component
public class MyItemReaderListener implements ItemReadListener<String> {
    @Override
    public void beforeRead() {
        System.out.println("before read");
    }

    @Override
    public void afterRead(String s) {
        System.out.println("after read: " + s);
    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("on read error: " + e.getMessage());
    }
}
