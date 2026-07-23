package com.carlota.securecourse.strategy;

import java.util.Objects;

/**
 * Context class for the Strategy pattern.
 */
public class GradeCalculator {

    private GradingStrategy strategy;

    public GradeCalculator(GradingStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(GradingStrategy strategy) {
        this.strategy = Objects.requireNonNull(
            strategy,
            "grading strategy cannot be null"
        );
    }

    public double calculate(
            double earnedPoints,
            double possiblePoints,
            int lateDays) {

        return strategy.calculateGrade(
            earnedPoints,
            possiblePoints,
            lateDays
        );
    }
}
