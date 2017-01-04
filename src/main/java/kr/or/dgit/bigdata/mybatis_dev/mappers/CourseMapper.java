package kr.or.dgit.bigdata.mybatis_dev.mappers;

import java.util.List;
import java.util.Map;

import kr.or.dgit.bigdata.mybatis_dev.dto.Course;

public interface CourseMapper {
	List<Course> searchCourses(Map<String, Object> map);
	List<Course> searchCaseCourses(Map<String, Object> map);
	List<Course> searchWhereCourses(Map<String, Object> map);
	List<Course> searchTrimCourses(Map<String, Object> map);
	List<Course> searchForeachCourseByTutors(Map<String, Object> map);
}
