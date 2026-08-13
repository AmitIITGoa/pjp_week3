/*
 * Expected outputs for the three required checks:
 * 1) Result: 13.00
 * 2) Error: Division by zero
 * 3) Error: Unknown operator '^'
 */

import java.util.Scanner;

public class SmartCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /, %): ");
            String operator = scanner.next();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = switch (operator) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero");
                        yield Double.NaN;
                    }
                    yield num1 / num2;
                }
                case "%" -> {
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero");
                        yield Double.NaN;
                    }
                    yield num1 % num2;
                }
                default -> {
                    System.out.println("Error: Unknown operator '" + operator + "'");
                    yield Double.NaN;
                }
            };

            if (!Double.isNaN(result)) {
                System.out.printf("Result: %.2f%n", result);
            }

            System.out.print("Do you want to continue? (y/n): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Exiting calculator. Goodbye!");
        scanner.close();
    }
}
