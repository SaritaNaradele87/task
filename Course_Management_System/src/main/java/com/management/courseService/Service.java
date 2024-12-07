package com.management.courseService;

import org.springframework.beans.factory.annotation.Autowired;

import com.management.CourseRepository;
import com.management.entity.Course;

public class Service implements ServiceInterface {

	@Autowired
	CourseRepository CourseReposiry;
	@Override
	public String Addcourse() {
	
		return null;
	}

	@Override
	public String updatcourse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteCourse() {
		// TODO Auto-generated method stub
		return null;
	}

}
