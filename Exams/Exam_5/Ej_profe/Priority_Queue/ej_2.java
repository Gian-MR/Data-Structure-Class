package Exam_5.Ej_profe.Priority_Queue;

import java.util.*;

public class ej_2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(5);
        pq.add(20);
        pq.add(15);
        pq.add(30);
        pq.add(48);
        pq.add(28);

         while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
