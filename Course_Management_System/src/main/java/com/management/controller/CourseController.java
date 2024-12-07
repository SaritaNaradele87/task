package com.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.management.entity.Course;
import com.management.courseService.CourseService;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course savedCourse = courseService.addCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

   

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourseById(
            @PathVariable Integer id,
            @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourseById(id, course);
        return ResponseEntity.ok(updatedCourse);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Integer id) {
        String result = courseService.deleteCourseById(id);
        return ResponseEntity.ok(result);
    }
}
