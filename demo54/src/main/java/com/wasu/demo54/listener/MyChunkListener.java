package com.wasu.demo54.listener;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName:MyChunkListener
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/3 11:16
 */
@Component
public class MyChunkListener implements ChunkListener {
    @Override
    public void beforeChunk(ChunkContext context) {
        System.out.println("before chunk: " + context.getStepContext().getStepName());
    }

    @Override
    public void afterChunk(ChunkContext context) {
        System.out.println("after chunk: " + context.getStepContext().getStepName());
    }

    @Override
    public void afterChunkError(ChunkContext context) {
        System.out.println("before chunk error: " + context.getStepContext().getStepName());
    }
}
