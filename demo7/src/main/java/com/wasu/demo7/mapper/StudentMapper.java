package com.wasu.demo7.mapper;

import com.wasu.demo7.bean.Student;
import org.apache.ibatis.annotations.*;


@Mapper
public interface StudentMapper {

	@Update("update student set sname=#{name} where sno=#{sno}")
	void update(Student student);

	@Delete("delete from student where sno=#{sno}")
	void deleteStudentBySno(String sno);

	@Select("select * from student where sno=#{sno}")
	@Results(id = "student", value = { @Result(property = "sno", column = "sno", javaType = String.class),
			@Result(property = "name", column = "sname", javaType = String.class),
			@Result(property = "sex", column = "ssex", javaType = String.class) })
	Student queryStudentBySno(String sno);
}
