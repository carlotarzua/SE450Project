package com.carlota.securecourse.builder;

import java.util.Objects;

import com.carlota.securecourse.model.Course;

/**
 * Director that controls the order used to construct a Course.
 */
public class CourseDirector {

    private final CourseBuilder builder;

    public CourseDirector(CourseBuilder builder) {
        this.builder = Objects.requireNonNull(
            builder,
            "builder cannot be null"
        );
    }

    public Course constructCourse(
            String code,
            String title,
            String instructorName,
            int capacity) {

        builder.reset();

        return builder
            .buildCode(code)
            .buildTitle(title)
            .buildInstructor(instructorName)
            .buildCapacity(capacity)
            .getCourse();
    }
}