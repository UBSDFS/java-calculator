// Calculator application main class

// Import necessary libraries
import java.util.Scanner;

// Main Calculator class
public class Calculator {
    // Main method to run the calculator application
    public static void main(String[] args) {
        // Welcome message
        System.out.println("-------------------------------------");
        System.out.println("Welcome to the Java Calculator!");
        System.out.println();
        System.out.println("Developed by Ulysses Burden III");
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

