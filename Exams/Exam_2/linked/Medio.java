package Exam_2.linked;

import java.util.*;

public class Medio {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(List.of("hello", "hi", "bye", "adios", "sayonara"));

        if (list.isEmpty()) {
            System.out.println("The list is empty");
            return;
        }

        Iterator<String> slow = list.iterator();
        Iterator<String> fast = list.iterator();

        String middle = slow.next();

        while (fast.hasNext()) {
            fast.next(); // fast avanza 1
            if (!fast.hasNext())
                break;
            fast.next(); // fast avanza 2

            middle = slow.next(); // slow avanza 1
        }
        System.out.println("The middle is: " + middle);
    }
}