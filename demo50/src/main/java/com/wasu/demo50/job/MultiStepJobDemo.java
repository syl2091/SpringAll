package com.wasu.demo50.job;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName:MultiStepJobDemo
 * @Description: 多步骤任务
 * @Author: Syl
 * @Date: 2021/8/25 17:10
 */
@Component
public class MultiStepJobDemo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job multiStepJob(){
        //多个步骤在执行过程中也可以通过上一个步骤的执行状态来决定是否执行下一个步骤，
        return jobBuilderFactory.get("multiStepJob3")
                .start(step1())
                .on(ExitStatus.COMPLETED.getExitCode()).to(step2())
                .from(step2())
                .on(ExitStatus.COMPLETED.getExitCode()).to(step3())
                .from(step3()).end()
                .build();
    }

    private Step step3() {
        return stepBuilderFactory.get("step3").tasklet((stepContribution, chunkContext) -> {
            System.out.println("执行步骤3操作!");
            return RepeatStatus.FINISHED;
        }).build();
    }

    private Step step2() {
        return stepBuilderFactory.get("step2").tasklet((stepContribution,chunkContext) -> {
            System.out.println("执行步骤2操作!");
            return RepeatStatus.FINISHED;
        }).build();
    }

    private Step step1() {
        return stepBuilderFactory.get("step1").tasklet((stepContribution,chunkContext) -> {
            System.out.println("执行步骤1操作!");
            return RepeatStatus.FINISHED;
        }).build();
    }
}
