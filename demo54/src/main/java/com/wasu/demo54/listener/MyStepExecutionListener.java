package com.wasu.demo54.listener;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.stereotype.Component;

/**
 * @ClassName:MyStepExecutionListener
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/3 11:15
 */
@Component
public class MyStepExecutionListener {
    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("before step execute: " + stepExecution.getStepName());
    }

    @AfterStep
    public void afterStep(StepExecution stepExecution) {
        System.out.println("after step execute: " + stepExecution.getStepName());
    }
}
