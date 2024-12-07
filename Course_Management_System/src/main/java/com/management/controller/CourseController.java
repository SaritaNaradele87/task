package com.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.management.courseService.Service;

@Controller
public class CourseController {
	
	@Autowired
	Service service;
	@
	public String AddCourse() {
		return service.Addcourse();
		
	}

}
