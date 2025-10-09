/*
 * Name: Ulysses Burden III
 * Assignment: Lab - Project User Interactions and I/O
 * Date: Oct 07, 2025
 */

 // Import necessary libraries
 import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        // Display welcome message and instructions
        System.out.println();
        System.out.println("Project: Week 1 - User Interactions and I/O");
        System.out.println("------Welcome to Ulysses's Calculator!------");
        System.out.println();
        System.out.println("This program will perform basic addition for two integers,");
        System.out.println("and basic subtraction for two floating-point numbers.");
        System.out.println();
        System.out.println("Please follow the prompts to enter your numbers.");
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println();

        // Prompt user for two integers and read input
        System.out.print("Please enter the first integer: ");
        int int1 = in.nextInt();
        System.out.print("Please enter the second integer: ");
        int int2 = in.nextInt();
        System.out.println();   

        // Perform addition and display result
        int sum = int1 + int2;
        System.out.println("The sum of %d and %d is: %d%n".formatted(int1,int2,sum));
        System.out.println();
        System.out.println("-------------------------------------");
        
        // Prompt user for two float numbers and read input
        System.out.print("Please enter the first float number: ");
        double num1 = in.nextDouble(); //Use doube for float input
        System.out.print("Please enter the second float number: ");
        double num2 = in.nextDouble();
        System.out.println();   

        // Perform subtraction and display result
        double difference = num1 - num2;
        System.out.println("The result of subtracting %.2f from %.2f is: %.2f%n".formatted(num1, num2, difference));
        System.out.println();
        System.out.println("-------------------------------------");

        in.close();
        System.out.println("Thank you for using Ulysses's Calculator. Goodbye!");   
    }
    
}
