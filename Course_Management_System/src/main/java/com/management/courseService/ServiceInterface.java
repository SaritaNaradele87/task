package com.management.courseService;
import java.util.List;

import com.management.entity.Course;

public interface CourseService {
	              Course addStudent(Course course);
	               Course getStudentbyId(Integer sid);
	               Course updateCoursebyId(Integer id,Course course);
	               	List<Course>getAllStudent();
	                 String deleteCoursebyId(Integer id);
	                	
   }
                 
