package Exam_4.Ej_prac.All;

import java.util.*;

public class practice3 {
    Map<String, Integer> StudentMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void fill(){
        for(int i = 0; i < 3; i++){
            try{
            System.out.println("Enter Student Name:");
            String name = sc.next();
            System.out.println("Enter Student Grade:");
            int grade = sc.nextInt();
            StudentMap.put(name, grade);

            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid grade.");
                sc.nextLine();
                i--; 
            }
        }
    }

    public void converter(){
        if(StudentMap.isEmpty()) {
            System.out.println("Nothing to Convert");
        } else {
            for (Map.Entry<String, Integer> e : StudentMap.entrySet()) {
                String name = e.getKey();
                int grade = e.getValue();
                
                if(grade >= 90){
                    System.out.println(name + ": " + grade + " -> A");
                } else if(grade >= 80){
                    System.out.println(name + ": " + grade + " -> B");
                } else if(grade >= 70){
                    System.out.println(name + ": " + grade + " -> C");
                } else if(grade >= 60){
                    System.out.println(name + ": " + grade + " -> D");
                } else {
                    System.out.println(name + ": " + grade + " -> F");
                }
            }
        }
    }

    public static void main(String[] args) {
        practice3 p = new practice3();
        p.fill();
        p.converter();
    }
}
