package Exam_1.two_classes;

import java.util.Scanner;

public class Books {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Store S = new Store();

        int num = 0;

        System.out.println("Enter User Name:");
        String input = sc.nextLine();
        System.out.println("Name: " + input);

        System.out.println("How many books:");
        try {
            num = sc.nextInt();
            sc.nextLine(); 
        } catch (Exception e) {
            System.out.println("Invalid number");
            sc.nextLine();
        }

        for (int i = 0; i < num; i++) {
            System.out.println("Name of book:");
            String name = sc.nextLine();
            S.addbook(name); 
        }

        S.showBooks();
        sc.close();
    }
}
