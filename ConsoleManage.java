//ConsoleManage class to handle console operations and clearing the screen

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
