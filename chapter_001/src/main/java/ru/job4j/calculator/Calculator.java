package ru.job4j.calculator;

public class Calculator {
    private double result;
    public void add(double fist, double second) {
        this.result = fist + second;
    }

    public void subtract(double fist, double second) {
        this.result = fist - second;
    }

    public void div(double fist, double second) {
        this.result = fist / second;
    }

    public void multiply(double fist, double second) {
        this.result = fist * second;
    }

    public double getResult() {
        return this.result;
    }
}