package com.wasu.demo54.listener;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName:MyItemWriterListener
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/3 11:19
 */
@Component
public class MyItemWriterListener implements ItemWriteListener<String> {

    @Override
    public void beforeWrite(List<? extends String> items) {
        System.out.println("before write: " + items);
    }

    @Override
    public void afterWrite(List<? extends String> items) {
        System.out.println("after write: " + items);
    }

    @Override
    public void onWriteError(Exception exception, List<? extends String> items) {
        System.out.println("on write error: " + items + " , error message: " + exception.getMessage());
    }
}