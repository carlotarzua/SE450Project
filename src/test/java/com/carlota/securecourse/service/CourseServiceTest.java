package com.carlota.securecourse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseServiceTest {
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseService();
    }

    @Test
    void shouldStartWithTwoDemoCourses() {
        assertEquals(2, courseService.getAllCourses().size());
    }

    @Test
    void shouldEnrollStudentInExistingCourse() {
        boolean enrolled = courseService.enrollStudent("SE450", "student@example.com");

        assertTrue(enrolled);
        assertEquals(
            1,
            courseService.findCourse("SE450").orElseThrow().getEnrollmentCount()
        );
    }

    @Test
    void shouldRejectDuplicateEnrollment() {
        assertTrue(courseService.enrollStudent("SE450", "student@example.com"));
        assertFalse(courseService.enrollStudent("SE450", "student@example.com"));
    }

    @Test
    void shouldReturnFalseForUnknownCourse() {
        assertFalse(courseService.enrollStudent("NOT-A-COURSE", "student@example.com"));
    }
}
