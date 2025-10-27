/*
 * MenuControl.java
 * Name: Ulysses Burden III
 * Assignment: Lab - Software Control Design-Calculator Application
 * Date: Oct 25, 2025
 */

import java.util.Scanner;

public class MenuControl {
    private final Scanner in;
    private final CalculatorEngine engine;
    private final MemoryStore memory; // shared instance for memory features

    // Constructor
    public MenuControl(Scanner in, CalculatorEngine engine) {
        this.in = in;
        this.engine = engine;
        this.memory = new MemoryStore(); // ✅ initializes final field
    }

    // Print main menu
    private void printMenu() {
        System.out.println("Select an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Memory");
        System.out.println("6. Exit");
        System.out.println("-------------------------------------");
    }

    // Method to run the menu control loop
    public void run() {
        // Loop until user chooses to exit
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Please select an option (1-6): ");
            // Validate input
            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                in.next();
                System.out.print("Please select an option (1-6): ");
            }

            int choice = in.nextInt();
            in.nextLine();

            if (choice == 1) {
                System.out.println("Addition Selected.");
                performOperation("add");
            } else if (choice == 2) {
                System.out.println("Subtraction Selected.");
                performOperation("subtract");
            } else if (choice == 3) {
                System.out.println("Multiplication Selected.");
                performOperation("multiply");
            } else if (choice == 4) {
                System.out.println("Division Selected.");
                performOperation("divide");
            } else if (choice == 5) {
                System.out.println("Opening Memory Menu..");
                MemControl memMenu = new MemControl(in, memory);
                memMenu.run();
            } else if (choice == 6) {
                running = false;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        System.out.println("Thank you for using the calculator. Goodbye!");
    }

    // Method to perform the selected arithmetic operation
    private void performOperation(String operation) {
        System.out.print("Enter the first number: ");
        double num1 = in.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = in.nextDouble();
        double result = 0;
        // Perform the operation based on user choice
        if (operation.equals("add")) {
            result = engine.add(num1, num2);
            System.out.printf("The result of adding %.2f and %.2f is: %.2f%n", num1, num2, result);
        } else if (operation.equals("subtract")) {
            result = engine.subtract(num1, num2);
            System.out.printf("The result of subtracting %.2f from %.2f is: %.2f%n", num2, num1, result);
        } else if (operation.equals("multiply")) {
            result = engine.multiply(num1, num2);
            System.out.printf("The result of multiplying %.2f and %.2f is: %.2f%n", num1, num2, result);
        } else if (operation.equals("divide")) {
            try {
                result = engine.divide(num1, num2);
                System.out.printf("The result of dividing %.2f by %.2f is: %.2f%n", num1, num2, result);
            } catch (IllegalArgumentException e) { // Catch division by zero exception
                System.out.println(e.getMessage()); // Display error message
            }
        }
        System.out.println("-------------------------------------");

    }
}
