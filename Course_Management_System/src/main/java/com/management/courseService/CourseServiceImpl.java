package com.management.courseService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.entity.Course;
import com.management.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

  

    @Override
    public Course updateCourseById(Integer id, Course course) {
        Course existingCourse = getCourseById(id);
        existingCourse.setCourseName(course.getCourseName()); 
        return courseRepository.save(existingCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public String deleteCourseById(Integer id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
        return "Course deleted with ID: " + id;
    }



	@Override
	public Course getCourseById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
