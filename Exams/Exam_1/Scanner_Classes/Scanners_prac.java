package Exam_1.Scanner_Classes;
import java.util.Scanner;

public class Scanners_prac {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int age = 0;
        double salary = 0.0;

        boolean validAge = false;
        boolean validSalary = false;

        // ===== AGE =====
        while (!validAge) {
            try {
                System.out.println("Enter your age: ");
                String input = sc.nextLine();

                age = Integer.parseInt(input); // risky line

                if (age > 0) {
                    validAge = true;
                } else {
                    System.out.println("Age must be positive.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }

        // ===== SALARY =====
        while (!validSalary) {
            try {
                System.out.println("Enter your salary: ");
                String input = sc.nextLine();

                salary = Double.parseDouble(input); // risky line

                if (salary >= 0) {
                    validSalary = true;
                } else {
                    System.out.println("Salary cannot be negative.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.println("\nSummary:");
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);

        sc.close();
    }
}