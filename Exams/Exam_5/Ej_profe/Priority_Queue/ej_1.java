package Exam_5.Ej_profe.Priority_Queue;

import java.util.PriorityQueue;

public class ej_1{
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);
        pq.add(50);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
