package Exam_4.Ej_prac.All;

import java.util.*;

public class practice2 {
    Map<String, Integer> studentsMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void fill_arrangement() {
        for (int i = 1; i < 4; i++) {
            System.out.println("Name: ");
            String name = sc.next();

            studentsMap.put(name, i);
        }
    }

    public void individual_sit() {
        if (studentsMap.isEmpty()){
            System.out.println("Theres no students");
        } else {
            System.out.println("Enter a name: ");
            String name = sc.next();
            System.out.println("Student: " + name + " Sit: " + studentsMap.get(name));
        }
    }

    public void print_arrangement() {
        for (Map.Entry<String, Integer> place : studentsMap.entrySet()) {
            String name = place.getKey();
            Integer sit = place.getValue();

            System.out.println("Student: " + name + " sit: " + sit + "\n");
        }
    }

    public static void main(String[] arg) {
        practice2 stu = new practice2();

        stu.fill_arrangement();

        stu.print_arrangement();

        stu.individual_sit();
    }
}
