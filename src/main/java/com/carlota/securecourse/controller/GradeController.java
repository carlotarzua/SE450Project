package com.carlota.securecourse.controller;

import java.util.Locale;
import java.util.Map;

import com.carlota.securecourse.strategy.GradeCalculator;
import com.carlota.securecourse.strategy.GradingStrategy;
import com.carlota.securecourse.strategy.LatePenaltyGradingStrategy;
import com.carlota.securecourse.strategy.StandardGradingStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class GradeController {

    @GetMapping("/api/instructor/grades/calculate")
    public Map<String, Object> calculateGrade(
            @RequestParam double earnedPoints,
            @RequestParam double possiblePoints,
            @RequestParam(defaultValue = "0") int lateDays,
            @RequestParam(defaultValue = "standard")
            String strategy) {

        String normalizedStrategy =
            strategy.toLowerCase(Locale.ROOT);

        GradingStrategy gradingStrategy =
            selectStrategy(normalizedStrategy);

        GradeCalculator calculator =
            new GradeCalculator(gradingStrategy);

        double finalGrade = calculator.calculate(
            earnedPoints,
            possiblePoints,
            lateDays
        );

        return Map.of(
            "strategy", normalizedStrategy,
            "earnedPoints", earnedPoints,
            "possiblePoints", possiblePoints,
            "lateDays", lateDays,
            "finalGrade", finalGrade
        );
    }

    private GradingStrategy selectStrategy(String strategy) {
        return switch (strategy) {
            case "standard" ->
                new StandardGradingStrategy();

            case "late" ->
                new LatePenaltyGradingStrategy(5.0);

            default ->
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Unknown grading strategy: " + strategy
                );
        };
    }
}
