package com.wasu.demo53.job;

import com.wasu.demo53.entity.TestData;
import com.wasu.demo53.processor.TestDataFilterItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName:TestDataFilterItemProcessorDemo
 * @Description: 自定义ItemProcessor的实现类 实现数据过滤
 * @Author: Syl
 * @Date: 2021/9/3 10:25
 */
@Component
public class TestDataFilterItemProcessorDemo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ListItemReader<TestData> itemReader;
    @Autowired
    private TestDataFilterItemProcessor testDataFilterItemProcessor;

    @Bean
    public Job testDataFilterItemProcessorJob(){
        return jobBuilderFactory.get("testDataFilterItemProcessorJob")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(itemReader)
                .processor(testDataFilterItemProcessor)
                .writer(list -> list.forEach(System.out::println))
                .build();
    }
}
