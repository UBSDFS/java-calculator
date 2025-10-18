/*
* Calculator.java
 * Name: Ulysses Burden III
 * Assignment: Week2 Lab - Software Control Design-Calculator Application
 * Date: Oct 07, 2025
 */

 // Import necessary libraries
 import java.util.Scanner;

 // Main Calculator class
public class Calculator {
    // Main method to run the calculator application
    public static void main(String [] args){
        // Welcome message
        System.out.println("Welcome to Ulysses's Calculator!");
        // Using try-with-resources to ensure Scanner is closed properly
        try(Scanner in = new Scanner(System.in)){
            // Instantiate CalculatorEngine and MenuControl
        CalculatorEngine engine = new CalculatorEngine();     
        MenuControl menu = new MenuControl(in, engine);
      // Run the menu control to start the application
        menu.run();
          

    }
}
}

