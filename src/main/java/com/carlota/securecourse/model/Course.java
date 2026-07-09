package com.carlota.securecourse.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Course {
    private final String code;
    private final String title;
    private final String instructorName;
    private final int capacity;
    private final List<String> enrolledStudentEmails = new ArrayList<>();

    public Course(String code, String title, String instructorName, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than zero");
        }

        this.code = Objects.requireNonNull(code, "code cannot be null");
        this.title = Objects.requireNonNull(title, "title cannot be null");
        this.instructorName = Objects.requireNonNull(instructorName, "instructorName cannot be null");
        this.capacity = capacity;
    }

    public boolean enrollStudent(String email) {
        Objects.requireNonNull(email, "email cannot be null");

        if (isFull() || enrolledStudentEmails.contains(email)) {
            return false;
        }

        enrolledStudentEmails.add(email);
        return true;
    }

    public boolean isFull() {
        return enrolledStudentEmails.size() >= capacity;
    }

    public int getEnrollmentCount() {
        return enrolledStudentEmails.size();
    }

    public List<String> getEnrolledStudentEmails() {
        return Collections.unmodifiableList(enrolledStudentEmails);
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public int getCapacity() {
        return capacity;
    }
}
