package com.wasu.demo55.listen;

import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName:MySkipListener
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/3 15:41
 */
@Component
public class MySkipListener implements SkipListener<String,String> {
    @Override
    public void onSkipInRead(Throwable throwable) {
        System.out.println("在读取数据的时候遇到异常并跳过，异常：" + throwable.getMessage());
    }

    @Override
    public void onSkipInWrite(String s, Throwable throwable) {
        System.out.println("在输出数据的时候遇到异常并跳过，待输出数据：" + s + "，异常：" + throwable.getMessage());
    }

    @Override
    public void onSkipInProcess(String s, Throwable throwable) {
        System.out.println("在处理数据的时候遇到异常并跳过，待输出数据：" + s + "，异常：" + throwable.getMessage());
    }
}
