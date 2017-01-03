package kr.or.dgit.bigdata.mybatis_dev.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.mybatis_dev.dto.Student;
import kr.or.dgit.bigdata.mybatis_dev.mappers.StudentMapper;
import kr.or.dgit.bigdata.mybatis_dev.util.MyBatisSqlSessionFactory;

public class StudentService {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(StudentService.class);

	private static final StudentService instance = new StudentService();
	
	public static StudentService getInstance(){
		return instance;
	}
	
	private StudentService(){}
	
	public Student findStudentById(int studId){
		if (logger.isDebugEnabled()) {
			logger.debug("findStudentById(int) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	public int insertStudent(Student student){
		if (logger.isDebugEnabled()) {
			logger.debug("insertStudent(Student) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int res = studentMapper.insertStudent(student);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertStudentAutoInc(Student student){
		if (logger.isDebugEnabled()) {
			logger.debug("insertStudentAutoInc(Student) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int res = studentMapper.insertStudentAutoInc(student);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateStudent(Student student){
		if (logger.isDebugEnabled()) {
			logger.debug("updateStudent(Student) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int res = studentMapper.updateStudent(student);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteStudent(int studId){
		if (logger.isDebugEnabled()) {
			logger.debug("deleteStudent(int) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int res = studentMapper.deleteStudent(studId);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Student> findAllStudents(){
		if (logger.isDebugEnabled()) {
			logger.debug("findAllStudents() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
	
	
	public Map<String, Object> findStudentByIdForMap(int studId) {
		if (logger.isDebugEnabled()) {
			logger.debug("findStudentByIdForMap(int) - start");
		}

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentByIdForMap(studId);
		} finally {
			sqlSession.close();
		}
	}
	
	
	public List<Map<String, Object>> findAllStudentsForMap(){
		if (logger.isDebugEnabled()) {
			logger.debug("findAllStudentsForMap() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudentsForMap();
		} finally {
			sqlSession.close();
		}
	}
	
	//===================================================Address조인
	
	public Student selectStudentWithAddress(int studId){
		if (logger.isDebugEnabled()) {
			logger.debug("selectStudentWithAddress(int) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.selectStudentWithAddress(studId);
		} finally {
			sqlSession.close();
		}
	}
	
	public Student selectStudentWithAddressResult(int studId){
		if (logger.isDebugEnabled()) {
			logger.debug("selectStudentWithAddressResult(int) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.selectStudentWithAddressResult(studId);
		} finally {
			sqlSession.close();
		}
	}
}
