package com.wasu.demo35.converter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @ClassName:PropertiesHttpMessageConverter
 * @Description: 自定义内容协商
 * @Author: Syl
 * @Date: 2021/8/12 16:26
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter {


    /**
     * 添加相应的媒体类型
     */
    public PropertiesHttpMessageConverter() {
        super(new MediaType("text", "properties"));
    }


    @Override
    protected void writeInternal(Object o, Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        // 获取请求头
        HttpHeaders headers = httpOutputMessage.getHeaders();
        // 获取 content-type
        MediaType contentType = headers.getContentType();
        // 获取编码
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }

        charset = charset == null ? Charset.forName("UTF-8") : charset;

        // 获取请求体
        OutputStream body = httpOutputMessage.getBody();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(body, charset);
        Properties properties = (Properties)o;
        properties.store(outputStreamWriter, "Serialized by PropertiesHttpMessageConverter#writeInternal");
    }

    @Override
    protected Object readInternal(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        Properties properties = new Properties();
        //获取请求头
        HttpHeaders headers = httpInputMessage.getHeaders();
        //获取content-type
        MediaType contentType = headers.getContentType();
        //获取编码
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }
        charset = charset==null?Charset.forName("utf-8"):charset;
        // 获取请求体
        InputStream body= httpInputMessage.getBody();
        InputStreamReader inputStreamReader = new InputStreamReader(body,charset);
        properties.load(inputStreamReader);
        return properties;
    }

    @Override
    public Object read(Type type, Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, httpInputMessage);
    }
}
