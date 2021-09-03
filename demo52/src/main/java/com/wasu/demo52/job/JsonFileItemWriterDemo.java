package com.wasu.demo52.job;

import com.wasu.demo52.entity.TestData;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import sun.dc.pr.PRError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName:JsonFileItemWriterDemo
 * @Description: 输出 json数据
 * @Author: Syl
 * @Date: 2021/9/2 17:04
 */
@Component
public class JsonFileItemWriterDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ListItemReader<TestData> listItemReader;

    @Bean
    public Job jsonFileItemWriterJob() throws IOException {
        return jobBuilderFactory.get("jsonFileItemWriterJob")
                .start(step())
                .build();
    }

    private Step step() throws IOException {
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(listItemReader)
                .writer(jsonFileItemWriter())
                .build();
    }

    private ItemWriter<? super TestData> jsonFileItemWriter() throws IOException {
        // 文件输出目标地址
        FileSystemResource file = new FileSystemResource("c:/Users/86177/Desktop/file.json");
        Path path = Paths.get(file.getPath());
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        // 将对象转换为json
        JacksonJsonObjectMarshaller<TestData> marshaller = new JacksonJsonObjectMarshaller<>();
        JsonFileItemWriter<TestData> writer = new JsonFileItemWriter<>(file, marshaller);
        // 设置别名
        writer.setName("testDatasonFileItemWriter");
        return writer;
    }

}
