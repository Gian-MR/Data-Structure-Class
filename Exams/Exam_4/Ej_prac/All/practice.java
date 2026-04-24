package Exam_4.Ej_prac.All;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class practice {

    static Map<String, Integer> map = new HashMap<>();

    public void is_allowed(String name) {
        Integer age = map.get(name);
        if (age == null) {
            System.out.println(name + " was not found.");
        } else if (age >= 18) {
            System.out.println(name + " is allowed.");
        } else {
            System.out.println(name + " is not allowed.");
        }
    }

    public void average_age() {
        int sum = 0, n = 0;
        for (Integer ages : map.values()) {
            sum += ages;
            n++;
        }
        System.out.println("The average age is: " + (double) sum / n);
    }

    public static void main(String[] arg) {
        practice p = new practice();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter name:");
            String name = sc.next();
            System.out.println("Enter age:");
            int age = sc.nextInt();
            map.put(name, age);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String name = e.getKey();
            int age = e.getValue();
            System.out.println("Username: " + name + "\nAge: " + age);
        }

        for (String name : map.keySet()) {
            p.is_allowed(name);
        }

        p.average_age();

        sc.close();
    }
}
