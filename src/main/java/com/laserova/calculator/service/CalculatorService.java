package com.laserova.calculator.service;

public interface CalculatorService {
    String welcome();

    long plus(int num1, int num2);

    long minus(int num1, int num2);

    long multiply(int num1, int num2);

    double divide(int num1, int num2);
}
