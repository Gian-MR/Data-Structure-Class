package Exam_3.Ej_posibles;

/*
Una biblioteca organiza los libros en una pila.
El último libro que se coloca es el primero que se retira.

Crea un programa que:
    - Utilice un Stack para almacenar los nombres de libros.
    - Pregunte al usuario cuántos libros desea agregar a la pila.
    - Utilice Scanner para leer los nombres de los libros.
    - Agregue cada libro a la pila.
    - Muestre la pila de libros.
    - Retire el último libro agregado.
    - Finalmente, muestre la pila después de retirar el libro.
*/

import java.util.Scanner;
import java.util.Stack;

class StackEjercicio {

    private Stack<String> libros = new Stack<>();

    public void agregarLibro(String nombre) {
        libros.push(nombre);
    }

    public void quitarLibro() {
        if (!libros.isEmpty()) {
            System.out.println("Libro retirado: " + libros.pop());
        }
    }

    public void mostrarPila() {
        System.out.println("Pila de libros: " + libros);
    }
}

public class StackMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StackEjercicio pila = new StackEjercicio();

        System.out.print("Cuantos libros desea apilar? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del libro: ");
            String libro = sc.nextLine();
            pila.agregarLibro(libro);
        }

        pila.mostrarPila();

        System.out.println("Quitando el ultimo libro...");
        pila.quitarLibro();

        pila.mostrarPila();
        sc.close();
    }
}
