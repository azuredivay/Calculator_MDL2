package com.codelads.calclibrary;

public class ArithmeticHelper {
    public static double Add(String A, String B)
    {
        double tempA = Double.parseDouble(A);
        double tempB = Double.parseDouble(B);
        return tempA + tempB;
    }

    public static double Add(double A, String B)
    {
        double tempB = Double.parseDouble(B);
        return A + tempB;
    }

    public static double Subtract(String A, String B)
    {
        Double tempA = Double.parseDouble(A);
        Double tempB = Double.parseDouble(B);
        return tempA - tempB;
    }

    public static double Subtract(double A, String B)
    {
        double tempB = Double.parseDouble(B);
        return A - tempB;
    }

    public static Double Divide(String A, String B)
    {
        if (!B.equalsIgnoreCase("0")) {
            Double tempA = Double.parseDouble(A);
            Double tempB = Double.parseDouble(B);
            return tempA / tempB;
        }
        return null;
    }

    public static Double Divide(double A, String B)
    {
        if (!B.equalsIgnoreCase("0"))
        {
            double tempB = Double.parseDouble(B);
            return A / tempB;
        }
        return null;
    }

    public static double Multiply(String A, String B)
    {
        Double tempA = Double.parseDouble(A);
        Double tempB = Double.parseDouble(B);
        return tempA * tempB;
    }

    public static double Multiply(double A, String B)
    {
        double tempB = Double.parseDouble(B);
        return A * tempB;
    }

    public static double SIN(double A)
    {
        return Math.sin(A);
    }

    public static double COS(double A)
    {
        return Math.cos(A);
    }

    public static double TAN(double A)
    {
        return Math.tan(A);
    }

}
