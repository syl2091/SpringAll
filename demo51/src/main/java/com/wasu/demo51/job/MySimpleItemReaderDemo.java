package com.wasu.demo51.job;

import com.wasu.demo51.reader.MySimpleIteamReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName:MySimpleItemReaderDemo
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/27 10:43
 */
@Component
public class MySimpleItemReaderDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job mySimpleItemReaderJob(){
        return jobBuilderFactory.get("mySimpleItemReaderJob").start(step()).build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<String, String>chunk(2)
                .reader(mySimpleItemReader())
                .writer(list -> list.forEach(System.out::println))
                .build();
    }

    private ItemReader<? extends String> mySimpleItemReader() {
        List<String> data = Arrays.asList("java","c++","python","go","c#","php");
        return new MySimpleIteamReader(data);
    }
}
