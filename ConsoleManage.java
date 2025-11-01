/*  
CalculatorEngine.java
 * Name: Ulysses Burden III
 * Assignment: Lab - Project Software Control Design-Calculator Application
 * Date: Oct 28, 2025
 */

public class ConsoleManage {
    private ConsoleManage() {
        // Private constructor to prevent instantiation
    }

    // Pause method to wait for user input before proceeding
    public static void pause(java.util.Scanner in) {
        System.out.println("\nPress Enter to continue...");
        in.nextLine();
    }

    public static void clearScreen() {
        // ANSI escape code to clear the console screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
