package org.example.Problems.KCalculator;

public class ExpressionParser {
    public static String[] parse(String expression) {
        return expression.trim().split(" ");
    }
}
