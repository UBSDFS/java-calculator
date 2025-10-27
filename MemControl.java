/*
 * Name: Ulysses Burden III
 * Assignment: Lab - Arrays and Lists - Calculator Application
 * Date: Oct 25, 2025
 */

import java.util.ArrayList;
import java.util.Scanner;

// MemControl class to handle memory operations
public class MemControl {
    private final Scanner in;
    private final MemoryStore memory;

    // Constructor
    public MemControl(Scanner in, MemoryStore memory) {
        this.in = in;
        this.memory = memory;
    }

    // Memory Menu options
    private void printMenu() {
        System.out.println("\n=== Memory Menu ===");

        System.out.println("Single Value");
        System.out.println("  1. Store value");
        System.out.println("  2. Recall value");
        System.out.println("  3. Clear value");
        System.out.println("  4. Replace value");

        System.out.println("\nCollection (up to 10 integers)");
        System.out.println("  5. Add value");
        System.out.println("  6. Remove value by index");
        System.out.println("  7. Display all values");
        System.out.println("  8. Display value count");
        System.out.println("  9. Sum of values");
        System.out.println(" 10. Average of values");
        System.out.println(" 11. Difference (first - last)");
        System.out.println(" 12. Clear collection");

        System.out.println("\n  0. Back to main menu");
        System.out.println("---------------------------");
    }

    // Memory control loop
    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Select an option (0-12): ");

            // Single value operations
            if (choice == 1) {
                int v = readInt("Enter an integer value: ");
                memory.storeSingle(v); // <-- store (or replace) single value
                System.out.println("Value stored in memory: " + memory.getSingle());
            } else if (choice == 2) {
                if (memory.hasSingle()) {
                    System.out.println("Value recalled from memory: " + memory.getSingle());
                } else {
                    System.out.println("No value is currently stored.");
                }
            } else if (choice == 3) {
                if (memory.hasSingle()) {
                    memory.clearSingle();
                    System.out.println("Single value memory cleared.");
                } else {
                    System.out.println("No value is currently stored.");
                }
            } else if (choice == 4) {
                int v = readInt("Enter a new integer value to replace: ");
                memory.storeSingle(v); // replace = store overwrite
                System.out.println("Value replaced in memory: " + memory.getSingle());
            }

            // Collection operations
            else if (choice == 5) {
                if (memory.isCollectionFull()) {
                    System.out.println("Collection is full. Remove a value before adding a new one.");
                } else {
                    int v = readInt("Enter an integer value to add to collection: ");
                    memory.addToCollection(v);
                    System.out.println("Value added. Count is now: " + memory.countCollection() + ".");
                }
            } else if (choice == 6) {
                int count = memory.countCollection();
                if (count == 0) {
                    System.out.println("Collection is empty. No values to remove.");
                } else {
                    System.out.println("Current collection values (1-based index):");
                    printIndexed(memory.getAll());
                    int index = readIntInRange("Enter index to remove (1-" + count + "): ", 1, count);
                    int removed = memory.removeByIndex(index - 1); // convert to 0-based
                    System.out.println("Removed value: " + removed);
                }
            } else if (choice == 7) {
                ArrayList<Integer> values = memory.getAll();
                if (values.isEmpty()) {
                    System.out.println("Collection is empty.");
                } else {
                    System.out.println("Values in collection:");
                    printIndexed(values);
                }
            } else if (choice == 8) {
                System.out.println("Number of values in collection: " + memory.countCollection());
            } else if (choice == 9) {
                if (memory.countCollection() == 0) {
                    System.out.println("Collection is empty. Sum is 0.");
                } else {
                    System.out.println("Sum of values in collection: " + memory.sum());
                }
            } else if (choice == 10) {
                if (memory.countCollection() == 0) {
                    System.out.println("Collection is empty. Average undefined.");
                } else {
                    double avg = memory.average();
                    System.out.printf("Average of values in collection: %.2f%n", avg);
                }
            } else if (choice == 11) {
                if (memory.countCollection() < 2) {
                    System.out.println("Collection must have at least two values to compute difference.");
                } else {
                    int diff = memory.diffFirstLast(); // first - last
                    System.out.println("Difference between first and last value: " + diff);
                }
            } else if (choice == 12) {
                if (memory.countCollection() == 0) {
                    System.out.println("Collection is already empty.");
                } else {
                    memory.clearCollection();
                    System.out.println("Collection cleared.");
                }
            }

            // Exit option
            else if (choice == 0) {
                running = false;
            } else {
                System.out.println("Invalid choice. Please select a valid option (0–12).");
            }
        }
    }

    // Get a valid integer from user
    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!in.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            in.next(); // clear invalid input token
            System.out.print(prompt);
        }
        int value = in.nextInt();
        in.nextLine(); // consume trailing newline
        return value;
    }

    // Get a valid integer within a range (used for removing by index)
    private int readIntInRange(String prompt, int min, int max) {
        int value = readInt(prompt);
        while (value < min || value > max) {
            System.out.println("Out of range. Enter a value between " + min + " and " + max + ".");
            value = readInt(prompt);
        }
        return value;
    }

    // Print each value in the collection with its position number (1-based)
    private void printIndexed(ArrayList<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            System.out.println((i + 1) + ": " + values.get(i));
        }
    }
}
