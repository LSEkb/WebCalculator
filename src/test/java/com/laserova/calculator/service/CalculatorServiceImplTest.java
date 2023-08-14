package com.laserova.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    CalculatorService sat = new CalculatorServiceImpl();

    @Test
    void welcome__returnWelcomeString() {
        String result = sat.welcome();
        assertEquals("Добро пожаловать в калькулятор", result);
    }

    @Test
    void plus_num1PlusNum2Ordinary_resultInt() {
        var result = sat.plus(4, 2);
        assertEquals(6, result);
    }

    @Test
    void plus_whenSumMoreThanMaxInteger_throwArithmeticException() {
        assertThrows(ArithmeticException.class, () -> sat.plus(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void minus_num1MinusNum2Ordinary_resultInt() {
        var result = sat.minus(4, 2);
        assertEquals(2, result);
    }

    @Test
    void minus_num1LessThanNum2_resultNegativeSign() {
        var result = sat.minus(2, 4);
        assertEquals(-2, result);

    }

    @Test
    void minus_whenDifferenceLessThanMaxInteger_throwArithmeticException() {
        assertThrows(ArithmeticException.class, () -> sat.minus(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void multiply_num1plusNum2BothPositiveSign_resultPositiveSign() {
        var result = sat.multiply(4, 2);
        assertEquals(8, result);
    }

    @Test
    void multiply_num1MultipliedNum2DifferentSigns_resultNegativeSign() {
        var result = sat.multiply(-4, 2);
        assertEquals(-8, result);
    }

    @Test
    void multiply_num1MultipliedNum2BothNegativeSigns_resultPositiveSign() {
        var result = sat.multiply(-4, -2);
        assertEquals(8, result);
    }

    @Test
    void multiply_num1AndNum2BothIsMaxInt_throwArithmeticException() {
        assertThrows(ArithmeticException.class, () -> sat.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void divide_num1DividedNum2WithoutFractional_resultWithoutFractional() {
        var result = sat.divide(4, 2);
        assertEquals(2, result);
    }

    @Test
    void divide_num1DividedNum2WithFractional_resultWithFractional() {
        var result = sat.divide(3, 2);
        assertEquals(1.5, result);
    }

    @Test
    void divide_num1DividedNum2DifferentSign_resultNegativeSign() {
        var result = sat.divide(-4, 2);
        assertEquals(-2, result);
    }

    @Test
    void divide_num2Is0_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> sat.divide(1, 0));
    }


    @ParameterizedTest
    @MethodSource("dataForPlus")
    void plus__returnInt(int num1, int num2, int expectedResult) {
        var result = sat.plus(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForPlus() {
        return Stream.of(
                Arguments.of(4, 2, 6),
                Arguments.of(-2, -2, -4),
                Arguments.of(-6, 2, -4),
                Arguments.of(4, -2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMinus")
    void minus__returnInt(int num1, int num2, int expectedResult) {
        var result = sat.minus(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMinus() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(2, 4, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMultiply")
    void multiply__returnInt(int num1, int num2, int expectedResult) {
        var result = sat.multiply(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMultiply() {
        return Stream.of(
                Arguments.of(4, 2, 8),
                Arguments.of(5, -2, -10),
                Arguments.of(-4, -2, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForDivide")
    void divide__returnDouble(int num1, int num2, double expectedResult) {
        var result = sat.divide(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForDivide() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(5, 2, 2.5),
                Arguments.of(4, -2, -2),
                Arguments.of(-4, -2, 2),
                Arguments.of(-4, 2, -2)
        );
    }
}