package com.wasu.demo51.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName:ItemReader
 * @Description: 简单数据读取
 * @Author: Syl
 * @Date: 2021/8/27 10:38
 */
public class MySimpleIteamReader implements ItemReader<String> {
    private Iterator<String> iterator;

    public MySimpleIteamReader(List<String> data) {
        this.iterator = data.iterator();
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return iterator.hasNext() ? iterator.next() : null;
    }
}
