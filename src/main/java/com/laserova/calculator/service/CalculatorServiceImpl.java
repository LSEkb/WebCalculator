package com.laserova.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public int plus(int num1, int num2) {
        int result = num1 + num2;
        return Math.addExact(num1,num2);
    }

    @Override
    public int minus(int num1, int num2) {
        int result = num1 - num2;
        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return Math.multiplyExact(num1, num2);
    }

    @Override
    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("/ by zero");
        }
        return (double) num1 / num2;
    }
}
