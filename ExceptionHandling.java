
/*
 * ExceptionHandling.java
 * Name: Ulysses Burden III
 * Assignment: Lab - Exception Handling for Calculator Application
 * Date: Oct 30, 2025
 */
import java.util.Scanner;

public class ExceptionHandling {

    // Private constructor prevents instantiation
    private ExceptionHandling() {
    }

    // Static method to validate and return a double
    public static double getValidatedDoubleValue(Scanner scanner) throws Exception {
        if (!scanner.hasNextDouble()) {
            scanner.next(); // consume the invalid token (not nextLine)
            throw new Exception("Invalid input. Please enter a valid number.");
        }
        return scanner.nextDouble();
    }
}
