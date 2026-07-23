package com.carlota.securecourse.strategy;

/**
 * Strategy interface for different grade calculation methods.
 */
public interface GradingStrategy {

    double calculateGrade(
        double earnedPoints,
        double possiblePoints,
        int lateDays
    );
}
