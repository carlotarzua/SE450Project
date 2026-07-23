package com.carlota.securecourse.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "application", "SecureCourse",
            "message", "Role-based learning management system starter project",
            "statusEndpoint", "/api/status"
        );
    }

    @GetMapping("/api/status")
    public Map<String, String> status() {
        return Map.of(
            "status", "running",
            "sprint", "Sprint 3"
        );
    }

    @GetMapping("/api/student/dashboard")
    public Map<String, String> studentDashboard() {
        return Map.of(
            "role", "STUDENT",
            "message", "Student dashboard access granted"
        );
    }

    @GetMapping("/api/instructor/dashboard")
    public Map<String, String> instructorDashboard() {
        return Map.of(
            "role", "INSTRUCTOR",
            "message", "Instructor dashboard access granted"
        );
    }

    @GetMapping("/api/admin/dashboard")
    public Map<String, String> adminDashboard() {
        return Map.of(
            "role", "ADMIN",
            "message", "Admin dashboard access granted"
        );
    }
}
