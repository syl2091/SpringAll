package com.wasu.demo55.job;

import com.wasu.demo55.exception.MyJobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * @ClassName:RetryExceptionJobDemo
 * @Description: 异常重试
 * @Author: Syl
 * @Date: 2021/9/3 13:48
 */
@Component
public class RetryExceptionJobDemo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job retryExceptionJob1() {
        return jobBuilderFactory.get("retryExceptionJob")
                .start(step())
                .build();

    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<String, String>chunk(2)
                .reader(listItemReader())
                .processor(myProcessor())
                .writer(list -> list.forEach(System.out::println))
                .faultTolerant() //配置错误容忍
                .retry(MyJobExecutionException.class) // 配置重试异常类型
                .retryLimit(3)//配置重试次数
                .build();
    }

    private ItemProcessor<? super String, ? extends String> myProcessor() {
        return new ItemProcessor<String, String>() {
            private int count;

            @Override
            public String process(String s) throws Exception {
                System.out.println("当前处理数据" + s);
                if (count >= 3) {
                    return s;
                } else {
                    count++;
                    throw new MyJobExecutionException("任务处理出错");
                }
            }
        };
    }

    private ListItemReader<String> listItemReader() {
        ArrayList<String> datas = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> datas.add(String.valueOf(i)));
        return new ListItemReader<>(datas);
    }
}
