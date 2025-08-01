package org.example.Problems.KCalculator;

public class OperationFactory {
    public static Operation getOperation(String operator) {
        return switch (operator) {
            case "+" -> new AddOperation();
            case "-" -> new SubtractOperation();
            case "*" -> new MultiplyOperation();
            case "/" -> new DivideOperation();
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}
