package com.wasu.demo55.job;

import com.wasu.demo55.exception.MyJobExecutionException;
import com.wasu.demo55.listen.MySkipListener;
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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * @ClassName:SkipExceptionJobDemo
 * @Description: 异常跳过
 * @Author: Syl
 * @Date: 2021/9/3 13:57
 */
@Component
public class SkipExceptionJobDemo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private MySkipListener mySkipListener;


    @Bean
    public Job skipExceptionJob4(){
        return jobBuilderFactory.get("skipExceptionJob4")
                .start(step())
                .build();
    }

    private Step step() {
        //Step中手动配置事务属性，事物的属性包括隔离等级（isolation）、传播方式（propagation）以及过期时间（timeout）等
        DefaultTransactionAttribute attribute = new DefaultTransactionAttribute();
        attribute.setPropagationBehavior(Propagation.REQUIRED.value());
        attribute.setIsolationLevel(Isolation.DEFAULT.value());
        attribute.setTimeout(30);
        return stepBuilderFactory.get("step")
                .<String, String>chunk(2)
                .reader(listItemReader())
                .processor(myProcessor())
                .writer(list -> list.forEach(System.out::println))
                .faultTolerant() //错误容忍
                .skip(MyJobExecutionException.class) //跳过指定异常
                .skipLimit(1)//跳过次数
                .listener(mySkipListener)
                .transactionAttribute(attribute)
                //.allowStartIfComplete(true) //allowStartIfComplete(true)来实现每次项目重新启动都将执行这个Step：
              //  .startLimit(3) //重启几次
                .build();
    }

    private ItemProcessor<? super String,? extends String> myProcessor() {
        return item ->{
            System.out.println("当前处理数据" + item);
            if ("2".equals(item)) {
                throw  new MyJobExecutionException("任务处理出错");
            }else {
                return item;
            }
        };
    }

    private ListItemReader<? extends String> listItemReader() {
        ArrayList<String> datas = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> datas.add(String.valueOf(i)));
        return new ListItemReader<>(datas);
    }
}
