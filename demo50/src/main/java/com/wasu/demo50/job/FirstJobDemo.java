package com.wasu.demo50.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName:FirstJobDemo
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/25 17:07
 */
@Component
public class FirstJobDemo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /**
     * 重新启动项目，控制台并不会再次打印出任务执行日志，因为Job名称和 Step名称组成唯一，执行完的不可重复的任务，不会再次执行。
     * @return
     */
    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("firstJob")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("执行步骤....");
                    return RepeatStatus.FINISHED;
                }).build();
    }
}
