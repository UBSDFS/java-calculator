/*
* Calculator.java
 * Name: Ulysses Burden III
 * Assignment: Week2 Lab - Software Control Design-Calculator Application
 * Date: Oct 25, 2025
 */

// Import necessary libraries
import java.util.Scanner;

// Main Calculator class
public class Calculator {
    // Main method to run the calculator application
    public static void main(String[] args) {
        // Welcome message
        System.out.println("-------------------------------------");
        System.out.println("Welcome to Ulysses's Calculator!");
        System.out.println("Week 4 Exception Handling");
        System.out.println();
        // Using try-with-resources to ensure Scanner is closed properly
        try (Scanner in = new Scanner(System.in)) {
            // Instantiate CalculatorEngine and MenuControl
            CalculatorEngine engine = new CalculatorEngine();
            MenuControl menu = new MenuControl(in, engine);
            // Run the menu control loop

            menu.run();
            in.close();
        }
    }
}

// Create exception handling for invalid inputs and all classes with following
// on message
// and prompt user to re-enter value
// "Invalid input. Please enter a valid number."