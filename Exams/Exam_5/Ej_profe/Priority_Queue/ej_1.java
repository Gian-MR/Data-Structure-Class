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
// Ejercicio 1
// Output:
// 10
// 20
// 30
// 40
// 50
//
// Porque PriorityQueue<Integer> por defecto es un min-heap.
// Eso significa que poll() elimina primero el número más pequeño.
