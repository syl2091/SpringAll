package com.wasu.demo52.job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wasu.demo52.entity.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName:FileItemWriterDemo
 * @Description: 输入文本数据
 * @Author: Syl
 * @Date: 2021/8/30 9:27
 */
@Component
public class FileItemWriterDemo {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ListItemReader<TestData> simpleReader;


    @Bean
    public Job fileItemWriterJob1() throws Exception {
        return jobBuilderFactory.get("fileItemWriterJob1")
                .start(step())
                .build();
    }

    private Step step() throws Exception {
        return stepBuilderFactory.get("step")
                .<TestData,TestData>chunk(2)
                .reader(simpleReader)
                .writer(fileItemWriter())
                .build();
    }

    private ItemWriter<? super TestData> fileItemWriter() throws Exception {
        logger.info("info");
        FlatFileItemWriter<TestData> writer = new FlatFileItemWriter<>();
        FileSystemResource file = new FileSystemResource("c:/Users/86177/Desktop/file");
        Path path = Paths.get(file.getPath());
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        // 设置输出文件路径
        writer.setResource(file);
        // 把读到的每个TestData对象转换为JSON字符串
        LineAggregator<TestData> aggregator = item -> {
            try {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.writeValueAsString(item);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return "";
        };

        writer.setLineAggregator(aggregator);
        writer.afterPropertiesSet();
        return writer;

    }
}
