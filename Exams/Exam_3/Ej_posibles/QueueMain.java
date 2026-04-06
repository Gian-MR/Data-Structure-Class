package Exam_3.Ej_posibles;

/*
Un banco maneja una fila de clientes esperando ser atendidos.

Crea un programa que:
    - Utilice una Queue para almacenar los nombres de los clientes.
    - Pregunte al usuario cuántos clientes llegan a la fila.
    - Utilice Scanner para leer los nombres de los clientes.
    - Agregue los clientes a la fila.
    - Muestre la fila completa de clientes.
    - Atienda al primer cliente en la fila.
    - Finalmente, muestre la fila restante.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class QueueEjercicio {

    private Queue<String> clientes = new LinkedList<>();

    public void agregarCliente(String nombre) {
        clientes.offer(nombre);
    }

    public void atenderCliente() {
        if (!clientes.isEmpty()) {
            System.out.println("Atendiendo a: " + clientes.poll());
        }
    }

    public void mostrarFila() {
        System.out.println("Fila actual: " + clientes);
    }
}

public class QueueMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QueueEjercicio fila = new QueueEjercicio();

        System.out.print("Cuantos clientes llegan a la fila? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del cliente: ");
            String nombre = sc.nextLine();
            fila.agregarCliente(nombre);
        }

        fila.mostrarFila();

        System.out.println("Atendiendo primer cliente...");
        fila.atenderCliente();

        fila.mostrarFila();
        sc.close();
    }
}
