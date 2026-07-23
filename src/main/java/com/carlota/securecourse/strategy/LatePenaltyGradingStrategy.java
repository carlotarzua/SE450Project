package com.carlota.securecourse.strategy;

/**
 * Calculates a percentage and subtracts a penalty for each late day.
 */
public class LatePenaltyGradingStrategy implements GradingStrategy {

    private final double penaltyPerDay;

    public LatePenaltyGradingStrategy(double penaltyPerDay) {
        if (penaltyPerDay < 0) {
            throw new IllegalArgumentException(
                "penalty per day cannot be negative"
            );
        }

        this.penaltyPerDay = penaltyPerDay;
    }

    @Override
    public double calculateGrade(
            double earnedPoints,
            double possiblePoints,
            int lateDays) {

        validateInput(earnedPoints, possiblePoints, lateDays);

        double originalGrade =
            earnedPoints / possiblePoints * 100.0;

        double penalizedGrade =
            originalGrade - lateDays * penaltyPerDay;

        return Math.max(penalizedGrade, 0.0);
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
