package com.wasu.demo55.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import sun.dc.pr.PRError;

/**
 * @ClassName:DefaultExceptionJobDemo
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/9/3 13:38
 */
@Component
public class DefaultExceptionJobDemo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job defaultExceptionJob1(){
        return jobBuilderFactory.get("defaultExceptionJob1")
                .start(
                        stepBuilderFactory.get("step")
                                .tasklet((stepContribution, chunkContext) -> {
                                    // 获取执行上下文
                                    ExecutionContext executionContext = chunkContext.getStepContext().getStepExecution().getExecutionContext();
                                    if (executionContext.containsKey("success")) {
                                        System.out.println("任务执行成功");
                                        return RepeatStatus.FINISHED;
                                    } else {
                                        String errorMessage = "处理任务过程发生异常";
                                        System.out.println(errorMessage);
                                        executionContext.put("success", true);
                                        throw new RuntimeException(errorMessage);
                                    }

                                }).startLimit(2).build()
                ).build();
    }
}
