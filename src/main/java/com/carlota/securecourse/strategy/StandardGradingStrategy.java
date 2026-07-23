package com.carlota.securecourse.strategy;

/**
 * Calculates a regular percentage without a late penalty.
 */
public class StandardGradingStrategy implements GradingStrategy {

    @Override
    public double calculateGrade(
            double earnedPoints,
            double possiblePoints,
            int lateDays) {

        validateInput(earnedPoints, possiblePoints, lateDays);

        return earnedPoints / possiblePoints * 100.0;
    }

    private void validateInput(
            double earnedPoints,
            double possiblePoints,
            int lateDays) {

        if (earnedPoints < 0) {
            throw new IllegalArgumentException(
                "earned points cannot be negative"
            );
        }

        if (possiblePoints <= 0) {
            throw new IllegalArgumentException(
                "possible points must be greater than zero"
            );
        }

        if (lateDays < 0) {
            throw new IllegalArgumentException(
                "late days cannot be negative"
            );
        }
    }
}
