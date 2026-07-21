package com.carlota.securecourse.builder;

import com.carlota.securecourse.model.Course;

public interface CourseBuilder {

    void reset();

    CourseBuilder buildCode(String code);

    CourseBuilder buildTitle(String title);

    CourseBuilder buildInstructor(String instructorName);

    CourseBuilder buildCapacity(int capacity);

    Course getCourse();
}