package kr.or.dgit.bigdata.mybatis_dev.mappers;

import java.util.List;

import kr.or.dgit.bigdata.mybatis_dev.dto.Student;

public interface StudentMapper {
	Student findStudentById(int studId);
	int insertStudent(Student student);
	int insertStudentAutoInc(Student student);
	int updateStudent(Student student);
	int deleteStudent(int studId);
	List<Student> findAllStudents();
}
