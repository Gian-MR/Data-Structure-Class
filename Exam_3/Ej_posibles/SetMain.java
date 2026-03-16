package Exam_3.Ej_posibles;

/*
Una tienda quiere registrar códigos de productos, pero no se permiten códigos repetidos.

Crea un programa que:
    - Utilice un Set para almacenar códigos de productos.
    - Pregunte al usuario cuántos códigos desea ingresar.
    - Utilice Scanner para leer cada código.
    - Si el código ya existe, muestre un mensaje indicando que el código está repetido.
    - Finalmente, muestre todos los códigos registrados.
*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SetEjercicio {

    private Set<String> codigos = new HashSet<>();

    public void agregarCodigo(String codigo) {
        if (!codigos.add(codigo)) {
            System.out.println("Codigo repetido: " + codigo);
        }
    }

    public void mostrarCodigos() {
        System.out.println("Codigos registrados:");
        for (String c : codigos) {
            System.out.println(c);
        }
    }
}

public class SetMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SetEjercicio set = new SetEjercicio();

        System.out.print("Cuantos codigos desea ingresar? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Codigo: ");
            String codigo = sc.nextLine();
            set.agregarCodigo(codigo);
        }

        set.mostrarCodigos();
        sc.close();
    }
}
