package com.wasu.demo7.service;

import com.wasu.demo7.bean.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface StudentService {
    void update(Student student);
    void deleteStudentBySno(String sno);
    Student queryStudentBySno(String sno);
}
