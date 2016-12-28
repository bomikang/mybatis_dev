package kr.or.dgit.bigdata.mybatis_dev;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.mybatis_dev.dto.PhoneNumber;
import kr.or.dgit.bigdata.mybatis_dev.dto.Student;
import kr.or.dgit.bigdata.mybatis_dev.service.StudentService;


public class StudentServiceTest {
	private static StudentService studentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		
		Assert.assertNotNull(student);
	}
	
	@Test
	public void testInsertStudent() {
		Student insStd = new Student();
		
		insStd.setStudId(4);
		insStd.setName("박경아");
		insStd.setEmail("pka@naver.com");
		insStd.setPhone(new PhoneNumber("010-5555-5555"));
		
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(1980, 0, 1);
		
		insStd.setDob(cal.getTime());
		
		int res = studentService.insertStudent(insStd); //성공은 1
		
		Assert.assertEquals(1, res);
	}


}
