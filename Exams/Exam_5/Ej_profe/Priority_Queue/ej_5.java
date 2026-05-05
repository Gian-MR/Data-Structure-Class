package Exam_5.Ej_profe.Priority_Queue;

import java.util.PriorityQueue;

class Estudiante {
    String name;
    int nota;

    Estudiante(String name, int nota) {
        this.name = name;
        this.nota = nota;
    }
}

public class ej_5 {
    public static void main(String[] args) {
        PriorityQueue<Estudiante> pq = new PriorityQueue<>(
                (a, b) -> b.nota - a.nota);

        pq.add(new Estudiante("Ana", 90));
        pq.add(new Estudiante("Yan", 65));
        pq.add(new Estudiante("Marcos", 88));
        pq.add(new Estudiante("Jose", 58));

        while (!pq.isEmpty()) {
            Estudiante e = pq.poll();
            System.out.println(e.name + " " + e.nota);
        }
    }
}