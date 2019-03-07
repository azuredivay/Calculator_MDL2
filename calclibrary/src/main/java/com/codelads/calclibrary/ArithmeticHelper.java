package com.codelads.calclibrary;

public class ArithmeticHelper {
    public static double Add(String A, String B) {
        double tempA = Double.parseDouble(A);
        double tempB = Double.parseDouble(B);
        return tempA + tempB;
    }

    public static double Add(double A, String B) {
        double tempB = Double.parseDouble(B);
        return A + tempB;
    }

    public static Double Subtract(String A, String B) {
        Double tempA = Double.parseDouble(A);
        Double tempB = Double.parseDouble(B);
        return tempA - tempB;
    }

    public static Double Divide(String A, String B) {
        if (!B.equalsIgnoreCase("0")) {
            Double tempA = Double.parseDouble(A);
            Double tempB = Double.parseDouble(B);
            return tempA / tempB;
        }
        return null;
    }

    public static Double Multiply(String A, String B) {
        Double tempA = Double.parseDouble(A);
        Double tempB = Double.parseDouble(B);
        return tempA * tempB;
    }
}