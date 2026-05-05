package Exam_5.Ej_profe.Priority_Queue;

import java.util.*;

public class ej_4 {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("pera");
        pq.add("acerola");
        pq.add("uva");
        pq.add("cereza");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

// Porque una PriorityQueue<String> normal en Java ordena los strings en orden
// alfabético natural.

// Entonces salen así: acerola, cereza, pera, uva