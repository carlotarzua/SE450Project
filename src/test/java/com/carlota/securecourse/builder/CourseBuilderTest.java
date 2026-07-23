package com.carlota.securecourse.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.carlota.securecourse.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseBuilderTest {

    private CourseBuilder builder;
    private CourseDirector director;

    @BeforeEach
    void setUp() {
        builder = new DefaultCourseBuilder();
        director = new CourseDirector(builder);
    }

    @Test
    void directorShouldConstructCourse() {
        Course course = director.constructCourse(
            "SE450",
            "Object Oriented Software Development",
            "Ben Harki",
            30
        );

        assertEquals("SE450", course.getCode());
        assertEquals(
            "Object Oriented Software Development",
            course.getTitle()
        );
        assertEquals("Ben Harki", course.getInstructorName());
        assertEquals(30, course.getCapacity());
    }

    @Test
    void builderShouldRejectIncompleteCourse() {
        builder.reset();
        builder.buildCode("SE450");

        assertThrows(
            IllegalStateException.class,
            builder::getCourse
        );
    }

    @Test
    void builderShouldRejectInvalidCapacity() {
        assertThrows(
            IllegalArgumentException.class,
            () -> builder.buildCapacity(0)
        );
    }

    @Test
    void directorShouldResetBuilderBeforeNewCourse() {
        Course first = director.constructCourse(
            "SE450",
            "Object Oriented Software Development",
            "Ben Harki",
            30
        );

        Course second = director.constructCourse(
            "MAT384",
            "Mathematical Modeling",
            "Demo Professor",
            20
        );

        assertEquals("SE450", first.getCode());
        assertEquals("MAT384", second.getCode());
        assertEquals(
            "Mathematical Modeling",
            second.getTitle()
        );
    }
}
