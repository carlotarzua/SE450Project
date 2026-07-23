package com.carlota.securecourse.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GradeCalculatorTest {

    private static final double DELTA = 0.001;

    @Test
    void shouldCalculateStandardPercentage() {
        GradeCalculator calculator =
            new GradeCalculator(new StandardGradingStrategy());

        double grade = calculator.calculate(80, 100, 0);

        assertEquals(80.0, grade, DELTA);
    }

    @Test
    void shouldApplyLatePenalty() {
        GradeCalculator calculator =
            new GradeCalculator(
                new LatePenaltyGradingStrategy(5.0)
            );

        double grade = calculator.calculate(90, 100, 2);

        assertEquals(80.0, grade, DELTA);
    }

    @Test
    void shouldAllowStrategyToChange() {
        GradeCalculator calculator =
            new GradeCalculator(new StandardGradingStrategy());

        double standardGrade =
            calculator.calculate(90, 100, 2);

        calculator.setStrategy(
            new LatePenaltyGradingStrategy(5.0)
        );

        double lateGrade =
            calculator.calculate(90, 100, 2);

        assertEquals(90.0, standardGrade, DELTA);
        assertEquals(80.0, lateGrade, DELTA);
    }

    @Test
    void lateGradeShouldNotBecomeNegative() {
        GradeCalculator calculator =
            new GradeCalculator(
                new LatePenaltyGradingStrategy(20.0)
            );

        double grade = calculator.calculate(50, 100, 5);

        assertEquals(0.0, grade, DELTA);
    }

    @Test
    void shouldRejectZeroPossiblePoints() {
        GradeCalculator calculator =
            new GradeCalculator(new StandardGradingStrategy());

        assertThrows(
            IllegalArgumentException.class,
            () -> calculator.calculate(50, 0, 0)
        );
    }

    @Test
    void shouldRejectNegativeLateDays() {
        GradeCalculator calculator =
            new GradeCalculator(
                new LatePenaltyGradingStrategy(5.0)
            );

        assertThrows(
            IllegalArgumentException.class,
            () -> calculator.calculate(80, 100, -1)
        );
    }
}
