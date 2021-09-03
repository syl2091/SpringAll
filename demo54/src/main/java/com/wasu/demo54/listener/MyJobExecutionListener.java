package com.wasu.demo54.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName:MyJobExecutionListener
 * @Description: 监听器演示
 * @Author: Syl
 * @Date: 2021/9/3 10:58
 */
@Component
public class MyJobExecutionListener implements JobExecutionListener {
    @Override
    public  void beforeJob(JobExecution jobExecution) {
        System.out.println("before job execute: " + jobExecution.getJobInstance().getJobName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("after job execute: " + jobExecution.getJobInstance().getJobName());
    }
}
