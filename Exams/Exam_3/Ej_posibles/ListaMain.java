package Exam_3.Ej_posibles;

/* 
Una universidad quiere registrar los nombres de estudiantes que se inscriben en un taller.
    Crea un programa que:
        - Utilice una List para almacenar nombres de estudiantes.
        - Pregunte al usuario cuántos estudiantes desea registrar.
        - Utilice Scanner para leer los nombres.
        - Agregue cada estudiante a la lista.
        - Finalmente,muestre todos los estudiantes registrados.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListaEjercicio {

    private List<String> estudiantes = new ArrayList<>();

    public void agregarEstudiante(String nombre) {
        estudiantes.add(nombre);
    }

    public void mostrarEstudiantes() {
        System.out.println("Lista de estudiantes:");
        for (String e : estudiantes) {
            System.out.println(e);
        }
    }
}

public class ListaMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaEjercicio lista = new ListaEjercicio();

        System.out.print("Cuantos estudiantes desea agregar? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            lista.agregarEstudiante(nombre);
        }

        lista.mostrarEstudiantes();
        sc.close();
    }
}