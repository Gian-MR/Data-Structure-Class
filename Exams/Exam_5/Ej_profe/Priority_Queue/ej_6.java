package Exam_5.Ej_profe.Priority_Queue;

import java.util.PriorityQueue;

public class ej_6 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(50);
        pq.add(20);
        pq.add(40);
        pq.add(10);
        pq.add(30);

        System.out.println("peek: " + pq.peek());
        System.out.println(pq);
    }
}

// |Pregunta|Respuesta||------------------------------------------|--------------------------------|

// Qué devuelve`peek()`?                        | `10`                             |
// | ¿Está completamente ordenado internamente? | No                               |
// | ¿Qué mostraría imprimir el queue?          | Algo como `[10, 20, 40, 50, 30]` |

// Porque PriorityQueue no mantiene todo el array ordenado.
// Solo garantiza que el elemento con mayor prioridad,
// en este caso el menor número, esté al frente.
