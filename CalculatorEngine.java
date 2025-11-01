/*  
CalculatorEngine.java
 * Name: Ulysses Burden III
 * Assignment: Lab - Project Software Control Design-Calculator Application
 * Date: Oct 25, 2025
 */

// CalculatorEngine class to perform basic arithmetic operations
public class CalculatorEngine {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0)
            throw new IllegalArgumentException("Division by zero is not allowed.");
        return a / b;
    }
}
