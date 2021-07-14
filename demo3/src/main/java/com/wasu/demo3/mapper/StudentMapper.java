package com.wasu.demo3.mapper;

import com.wasu.demo3.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName:StudentMapper
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/14 16:08
 */
@Mapper
@Component
public interface StudentMapper {
    @Insert("insert into student(sno,sname,ssex) values(#{sno},#{name},#{sex})")
    int add(Student student);

    @Update("update student set sname = #{name},ssex=#{ssex} where sno=#{sno}")
    int update(Student student);

    @Delete("delete from student where sno=#{sno}")
    int deleteBySno(String sno);

    @Select("select * from student where sno=#{sno}")
    @Results(id = "student", value = {
            @Result(property = "sno",column = "sno",javaType = String.class),
            @Result(property = "name",column = "sname",javaType = String.class),
            @Result(property = "sex",column = "ssex",javaType = String.class)
    })
    Student queryStudentBySno(String sno);
}
