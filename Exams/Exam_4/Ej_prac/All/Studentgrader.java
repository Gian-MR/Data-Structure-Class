package Exam_4.Ej_prac.All;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Studentgrader {

    static Map<String, Integer> map = new HashMap<>();

    public void grader() {
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String name = e.getKey();
            int grade = e.getValue();

            if (grade >= 60) {
                System.out.println("Student: " + name + " passed the class.");
            } else {
                System.out.println("Student: " + name + " didnt pass the class.");
            }
            System.out.println("\n");
        }
    }

    public void individual_grade(String name) {
        System.out.println("Student: " + name + " Grade: " + map.getOrDefault(name, 0));
    }


    public static void main(String [] arg){
        Studentgrader Stu = new Studentgrader();
        Scanner sc = new Scanner(System.in);

        System.out.println("Name and grade pls: (5)\n");
        
        for(int i = 0; i < 3; i++){
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Grade:");
            int grade = sc.nextInt();

            map.put(name, grade);
            System.out.println("\n");
        }

        Stu.grader();

        System.out.println("Now lets test individual grades: \n");
        System.out.println("Name: ");

        String name = sc.next();
        Stu.individual_grade(name);        

        sc.close();
    }
}
