package com.carlota.securecourse.controller;

import java.util.List;

import com.carlota.securecourse.model.Course;
import com.carlota.securecourse.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/api/student/courses")
    public List<Course> listCoursesForStudents() {
        return courseService.getAllCourses();
    }

    @GetMapping("/api/instructor/courses")
    public List<Course> listCoursesForInstructors() {
        return courseService.getAllCourses();
    }
}
