package Exam_2.List_Array_LinkedList;
import java.util.*;

public class LinkedListTesting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // LinkedLists
        LinkedList<String> waitingLine = new LinkedList<>();
        LinkedList<String> servedHistory = new LinkedList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add student to waiting line");
            System.out.println("2. Serve next student");
            System.out.println("3. View next student");
            System.out.println("4. Remove a student by name");
            System.out.println("5. Show waiting line");
            System.out.println("6. Show served history");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    waitingLine.addLast(name); // enqueue
                    System.out.println(name + " added to the line.");
                    break;

                case "2":
                    if (waitingLine.isEmpty()) {
                        System.out.println("No students to serve.");
                    } else {
                        String served = waitingLine.removeFirst(); // dequeue
                        servedHistory.add(served);
                        System.out.println("Served: " + served);
                    }
                    break;

                case "3":
                    if (waitingLine.isEmpty()) {
                        System.out.println("No students waiting.");
                    } else {
                        System.out.println("Next student: " + waitingLine.getFirst());
                    }
                    break;

                case "4":
                    System.out.print("Enter student name to remove: ");
                    String removeName = sc.nextLine();

                    if (waitingLine.remove(removeName)) {
                        System.out.println(removeName + " removed from the line.");
                    } else {
                        System.out.println(removeName + " not found.");
                    }
                    break;

                case "5":
                    System.out.println("\n--- Waiting Line ---");
                    if (waitingLine.isEmpty()) {
                        System.out.println("Empty");
                    } else {
                        for (String student : waitingLine) {
                            System.out.println(student);
                        }
                    }
                    break;

                case "6":
                    System.out.println("\n--- Served History ---");
                    if (servedHistory.isEmpty()) {
                        System.out.println("No students served yet.");
                    } else {
                        for (String student : servedHistory) {
                            System.out.println(student);
                        }
                    }
                    break;

                case "7":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }
}