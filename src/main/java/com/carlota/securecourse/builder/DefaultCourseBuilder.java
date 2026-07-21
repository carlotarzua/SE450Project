package com.carlota.securecourse.builder;

import com.carlota.securecourse.model.Course;

/**
 * Concrete Builder that stores course information and creates a Course.
 */
public class DefaultCourseBuilder implements CourseBuilder {

    private String code;
    private String title;
    private String instructorName;
    private int capacity;

    public DefaultCourseBuilder() {
        reset();
    }

    @Override
    public void reset() {
        code = null;
        title = null;
        instructorName = null;
        capacity = 0;
    }

    @Override
    public CourseBuilder buildCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public CourseBuilder buildTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public CourseBuilder buildInstructor(String instructorName) {
        this.instructorName = instructorName;
        return this;
    }

    @Override
    public CourseBuilder buildCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "capacity must be greater than zero"
            );
        }

        this.capacity = capacity;
        return this;
    }

    @Override
    public Course getCourse() {
        validateRequiredFields();

        return new Course(
            code,
            title,
            instructorName,
            capacity
        );
    }

    private void validateRequiredFields() {
        if (code == null || code.isBlank()) {
            throw new IllegalStateException("course code is required");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalStateException("course title is required");
        }

        if (instructorName == null || instructorName.isBlank()) {
            throw new IllegalStateException("instructor name is required");
        }

        if (capacity <= 0) {
            throw new IllegalStateException(
                "course capacity is required"
            );
        }
    }
}