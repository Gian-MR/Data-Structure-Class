package Exam_3.Ej_posibles;

/*
En un restaurante hay una fila de clientes.
Los clientes normales entran al final de la fila, pero los clientes VIP entran al frente.

Crea un programa que:
    - Utilice una Deque para manejar la fila.
    - Pregunte al usuario cuántos clientes normales llegan.
    - Utilice Scanner para leer los nombres de los clientes normales.
    - Agregue los clientes normales al final de la fila.
    - Luego pida el nombre de un cliente VIP.
    - Agregue el cliente VIP al frente de la fila.
    - Finalmente, muestre la fila completa.
*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class DequeEjercicio {

    private Deque<String> fila = new LinkedList<>();

    public void agregarNormal(String nombre) {
        fila.addLast(nombre);
    }

    public void agregarVIP(String nombre) {
        fila.addFirst(nombre);
    }

    public void mostrarFila() {
        System.out.println("Fila actual: " + fila);
    }
}

public class DequeMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DequeEjercicio deque = new DequeEjercicio();

        System.out.print("Cuantos clientes normales? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Cliente normal: ");
            String nombre = sc.nextLine();
            deque.agregarNormal(nombre);
        }

        System.out.print("Nombre cliente VIP: ");
        String vip = sc.nextLine();
        deque.agregarVIP(vip);

        deque.mostrarFila();
        sc.close();
    }
}
