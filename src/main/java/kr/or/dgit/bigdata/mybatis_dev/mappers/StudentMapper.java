package kr.or.dgit.bigdata.mybatis_dev.mappers;

import java.util.List;
import java.util.Map;

import kr.or.dgit.bigdata.mybatis_dev.dto.Student;

public interface StudentMapper {
	Student findStudentById(int studId);
	List<Student> findAllStudents();
	
	Map<String,Object> findStudentByIdForMap(int studId); //key값은 Student의 변수들 값이 됨.
	List<Map<String, Object>> findAllStudentsForMap();
	
	int insertStudent(Student student);
	int insertStudentAutoInc(Student student);
	int updateStudent(Student student);
	int deleteStudent(int studId);
	
}
