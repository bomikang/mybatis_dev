package kr.or.dgit.bigdata.mybatis_dev;

import java.util.Date;

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

//	@Test
//	public void testFindStudentById() {
//		Student student = studentService.findStudentById(1);
//		
//		Assert.assertNotNull(student);
//	}
	
//	@Test
//	public void testInsertStudent() {
//		Student insStd = new Student();
//		
//		insStd.setStudId(4);
//		insStd.setName("박경아");
//		insStd.setEmail("pka@naver.com");
//		insStd.setPhone(new PhoneNumber("010-5555-5555"));
//		
//		Calendar cal = Calendar.getInstance();
//		cal.clear();
//		cal.set(1980, 0, 1);
//		
//		insStd.setDob(cal.getTime());
//		
//		int res = studentService.insertStudent(insStd); //성공은 1
//		
//		Assert.assertEquals(1, res);
//	}

//	@Test
//	public void testInsertStudentAutoInc() {
//		Student insStd = new Student();
//		
//		insStd.setName("박경아222");
//		insStd.setEmail("pka@naver.com");
//		insStd.setPhone(new PhoneNumber("010-5555-5555"));
//		
//		Calendar cal = Calendar.getInstance();
//		cal.clear();
//		cal.set(1980, 0, 1);
//		
//		insStd.setDob(cal.getTime());
//		
//		int res = studentService.insertStudentAutoInc(insStd); //성공은 1
//		
//		Assert.assertEquals(1, res);
//	}
	
//	@Test
//	public void testUpdateStudent(){
//		Student upStd = new Student();
//		
//		upStd.setName("히히히");
//		upStd.setEmail("abcc@ablc.co.kr");
//		upStd.setPhone(new PhoneNumber("011-6586-8848"));
//		
//		Calendar cal = Calendar.getInstance();
//		cal.clear();
//		cal.set(1995, 2, 8);
//		
//		upStd.setDob(cal.getTime());
//		
//		upStd.setStudId(7);
//		
//		int res = studentService.updateStudent(upStd);
//		
//		Assert.assertEquals(1, res);
//	}
	
//	@Test
//	public void testDeleteStudent(){
//		int res = studentService.deleteStudent(7);
//		
//		Assert.assertEquals(1, res);
//	}
	
//	@Test
//	public void testFindAllStudents(){
//		List<Student> list = studentService.findAllStudents();
//		
//		Assert.assertNotNull(list);
//		
//		for (Student s : list) {
//			System.out.println(s);
//		}
//	}
	
//	@Test
//	public void testfindStudentByIdForMap() {
//		Map<String, Object> stdmap = studentService.findStudentByIdForMap(1);
//		
//		Assert.assertNotNull(stdmap);
//		
//		for (Entry<String, Object> e : stdmap.entrySet()) {
//			System.out.printf("%s -> %s%n", e.getKey(), e.getValue());
//		}
//
//	}
	
//	@Test
//	public void findAllStudentsForMap(){
//		List<Map<String, Object>> list = studentService.findAllStudentsForMap();
//		
//		Assert.assertNotNull(list);
//	}
	
//	@Test
//	public void testSelectStudentWithAddress() {
//		Student student = studentService.selectStudentWithAddress(1);
//		
//		Assert.assertNotNull(student);
//	}
	
	@Test
	public void testSelectStudentWithAddressResult() {
		Student student = studentService.selectStudentWithAddressResult(1);
		
		Assert.assertNotNull(student);
	}
	
	@Test
	public void testUpdateSetStudent(){
		Student student = new Student();
		student.setStudId(6);
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("010-2772-7827"));
		student.setDob(new Date());
		
		int res = studentService.updateSetStudent(student);
		
		Assert.assertSame(1, res);
	}
}
