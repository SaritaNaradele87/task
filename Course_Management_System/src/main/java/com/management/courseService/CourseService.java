package com.management.courseService;
import java.util.List;

import com.management.entity.Course;



public interface CourseService {
					Course addCourse(Course course);
					Course getCourseById(Integer id);
					Course updateCourseById(Integer id, Course course);
					List<Course> getAllCourses();
					String deleteCourseById(Integer id);
					
	                	
   }
                 
