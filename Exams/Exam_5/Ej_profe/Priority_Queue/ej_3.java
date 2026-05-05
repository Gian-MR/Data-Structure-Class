package Exam_5.Ej_profe.Priority_Queue;

import java.util.*;

public class ej_3 {
   public static void main(String[] args) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();

       pq.add(8);
       pq.add(3);
       pq.add(12);
       pq.add(1);

       System.out.println(pq.peek());
       System.out.println(pq.size());

       pq.poll();

       System.out.println(pq.peek());
   } 
}
