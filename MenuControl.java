
//Menu Control class to handle user interactions and menu navigation
import java.util.Scanner;

public class MenuControl {
    private final Scanner in;
    private final CalculatorEngine engine;
    private final MemoryStore memory; // shared instance for memory feature

    // Constructor
    public MenuControl(Scanner in, CalculatorEngine engine) {
        this.in = in;
        this.engine = engine;
        this.memory = new MemoryStore(); // ✅ initializes final field
    }

    private void pauseAndClear() {
        ConsoleManage.pause(in);
        ConsoleManage.clearScreen();
    }

    // Print main menu
    private void printMenu() {
        System.out.println("-------------------------------------");
        System.out.println("           Calculator Menu           ");
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
    // with exception handling for invalid inputs
    private void performOperation(String operation) {
        double num1 = 0;
        double num2 = 0;
        while (true) {
            try {
                System.out.print("Enter the first number: ");
                num1 = ExceptionHandling.getValidatedDoubleValue(in);
                break; // Exit loop if both numbers are valid

            } catch (Exception e) {
                System.out.println(e.getMessage());
                in.nextLine(); // Clear the invalid input

            }
        }
        while (true) {
            try {
                System.out.print("Enter the second number: ");
                num2 = ExceptionHandling.getValidatedDoubleValue(in);
                break; // Exit loop if both numbers are valid

            } catch (Exception e) {
                System.out.println(e.getMessage());
                in.nextLine(); // Clear the invalid input

            }
        }
        double result;
        // Perform the operation based on user choice
        if (operation.equals("add")) {
                        result = engine.add(num1, num2);
            System.out.printf("The result of adding %.2f and %.2f is: %.2f%n", num1, num2, result);
            in.nextLine();
            pauseAndClear();
        } else if (operation.equals("subtract")) {
            result = engine.subtract(num1, num2);
            System.out.printf("The result of subtracting %.2f from %.2f is: %.2f%n", num2, num1, result);
            in.nextLine();
            pauseAndClear();
        } else if (operation.equals("multiply")) {
            result = engine.multiply(num1, num2);
            System.out.printf("The result of multiplying %.2f and %.2f is: %.2f%n", num1, num2, result);
            in.nextLine();
            pauseAndClear();
        } else if (operation.equals("divide")) {
            while (num2 == 0) {
                System.out.println("Division by zero is not allowed.");
                while (true) {
                    try {
                        System.out.print("Enter the second number: ");
                        num2 = ExceptionHandling.getValidatedDoubleValue(in);
                        in.nextLine(); // Clear the invalid input
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        in.nextLine(); // Clear the invalid input
                    }
                }
            }
            result = engine.divide(num1, num2);
            System.out.printf("The result of dividing %.2f by %.2f is: %.2f%n", num1, num2, result);
            in.nextLine();
            pauseAndClear();
        } else {

            System.out.println("Invalid operation.");
        }
    }
}
