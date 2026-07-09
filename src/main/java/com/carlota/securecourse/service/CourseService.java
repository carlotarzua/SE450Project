package com.carlota.securecourse.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.carlota.securecourse.model.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final Map<String, Course> courses = new LinkedHashMap<>();

    public CourseService() {
        addCourse(new Course("SE450", "Object Oriented Software Development", "Ben Harki", 30));
        addCourse(new Course("CSC321", "Design and Analysis of Algorithms", "Demo Instructor", 25));
    }

    public void addCourse(Course course) {
        if (courses.containsKey(course.getCode())) {
            throw new IllegalArgumentException("course code already exists: " + course.getCode());
        }
        courses.put(course.getCode(), course);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    public Optional<Course> findCourse(String code) {
        return Optional.ofNullable(courses.get(code));
    }

    public boolean enrollStudent(String courseCode, String studentEmail) {
        Course course = courses.get(courseCode);
        if (course == null) {
            return false;
        }
        return course.enrollStudent(studentEmail);
    }
}
