package com.laserova.calculator.service;

public interface CalculatorService {
    String welcome();

    int plus(int num1, int num2);

    int minus(int num1, int num2);

    int multiply(int num1, int num2);

    double divide(int num1, int num2);
}
