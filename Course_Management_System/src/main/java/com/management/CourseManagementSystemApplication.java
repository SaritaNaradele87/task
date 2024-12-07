package com.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.entity.Course;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Integer>{
 
}
