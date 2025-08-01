package org.example.Problems.KCalculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an expression (e.g., 4 + 5):");
        String input = scanner.nextLine();

        try {
            String[] tokens = ExpressionParser.parse(input);
            double operand1 = Double.parseDouble(tokens[0]);
            String operator = tokens[1];
            double operand2 = Double.parseDouble(tokens[2]);

            Operation operation = OperationFactory.getOperation(operator);
            double result = operation.execute(operand1, operand2);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
