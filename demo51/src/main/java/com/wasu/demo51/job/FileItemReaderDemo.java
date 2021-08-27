package com.wasu.demo51.job;

import com.wasu.demo51.entity.TestData;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * @ClassName:FileItemReaderDemo
 * @Description: 文本读取数据
 * @Author: Syl
 * @Date: 2021/8/27 11:06
 */
@Component
public class FileItemReaderDemo{

    //任务工厂
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    //步骤工厂
    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job fileItemReader1Job(){
        return jobBuilderFactory.get("fileItemReader1Job").start(step()).build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(fileItemRead())
                .writer(list -> {
                    list.forEach(System.out::println);
                }).build();
    }

    private ItemReader<? extends TestData> fileItemRead() {
        FlatFileItemReader<TestData> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("file"));//设置源文件地址
        reader.setLinesToSkip(1);//设置忽略第一行
        // AbstractLineTokenizer的三个实现类之一，以固定分隔符处理行数据读取,
        // 使用默认构造器的时候，使用逗号作为分隔符，也可以通过有参构造器来指定分隔符
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        // 设置属性名，类似于表头
        tokenizer.setNames("id", "field1", "field2", "field3");
        // 将每行数据转换为TestData对象
        DefaultLineMapper<TestData> mapper = new DefaultLineMapper<>();
        // 设置LineTokenizer
        mapper.setLineTokenizer(tokenizer);
        // 设置映射方式，即读取到的文本怎么转换为对应的POJO
        mapper.setFieldSetMapper(fieldSet -> {
            TestData testData  = new TestData();
            testData.setId(fieldSet.readInt("id"));
            testData.setField1(fieldSet.readString("field1"));
            testData.setField2(fieldSet.readString("field2"));
            testData.setField3(fieldSet.readString("field3"));
            return testData;
        });

        reader.setLineMapper(mapper);
        return reader;
    }
}
