package com.wasu.demo53.job;

import com.wasu.demo53.entity.TestData;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName:BeanValidatingItemProcessorDemo
 * @Description: 注解校验
 * @Author: Syl
 * @Date: 2021/9/3 10:21
 */
@Component
public class BeanValidatingItemProcessorDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ListItemReader<TestData> simpleReader;

    @Bean
    public Job beanValidatingItemProcessorJob1() throws Exception {
        return jobBuilderFactory.get("beanValidatingItemProcessorJob1")
                .start(step())
                .build();
    }

    private Step step() throws Exception {
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(simpleReader)
                .processor(beanValidatingItemProcessor())
                .writer(list -> list.forEach(System.out::println))
                .build();
    }

    private BeanValidatingItemProcessor<TestData> beanValidatingItemProcessor() throws Exception {
        BeanValidatingItemProcessor<TestData> beanValidatingItemProcessor = new BeanValidatingItemProcessor<>();
        // 开启过滤，不符合规则的数据被过滤掉；
        beanValidatingItemProcessor.setFilter(true);
        beanValidatingItemProcessor.afterPropertiesSet();
        return beanValidatingItemProcessor;
    }
}