package com.wasu.demo52.writer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wasu.demo52.entity.TestData;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:ItemWriterConfigure
 * @Description: 多文本输出
 * @Author: Syl
 * @Date: 2021/9/3 9:09
 */
@Component
public class ItemWriterConfigure {
    @Bean
    public FlatFileItemWriter<TestData> fileItemWriter() throws Exception {
        FlatFileItemWriter<TestData> writer = new FlatFileItemWriter<>();

        FileSystemResource file = new FileSystemResource("c:/Users/86177/Desktop/file");
        Path path = Paths.get(file.getPath());
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        writer.setResource(file); // 设置目标文件路径

        // 把读到的每个TestData对象转换为字符串
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
    @Bean
    public StaxEventItemWriter<TestData> xmlFileItemWriter() throws Exception {
        StaxEventItemWriter<TestData> writer = new StaxEventItemWriter<>();

        // 通过XStreamMarshaller将TestData转换为xml
        XStreamMarshaller marshaller = new XStreamMarshaller();

        Map<String, Class<TestData>> map = new HashMap<>(1);
        map.put("test", TestData.class);

        marshaller.setAliases(map); // 设置xml标签

        writer.setRootTagName("tests"); // 设置根标签
        writer.setMarshaller(marshaller);

        FileSystemResource file = new FileSystemResource("c:/Users/86177/Desktop/file.xml");
        Path path = Paths.get(file.getPath());
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        writer.setResource(file); // 设置目标文件路径
        return writer;
    }
}
