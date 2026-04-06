package Exam_3.Mock;

import java.util.*;

public class Historial {
    Stack<String> nombre = new Stack<>();
    Stack<String> producto = new Stack<>();
    Stack<String> precio = new Stack<>();

    void agregarCliente(String n){
        nombre.add(n);
    }
    void agregarProducto(String p){
        producto.add(p);
    }
    void agregarPrecio(String p){
        precio.add(p);
    }

    void undo(){
        String pedido = "";
        pedido += nombre.pop();
        pedido += ", " + producto.pop();
        pedido += ", " + precio.pop();
        System.out.println(pedido);
    }

    void ultimo() {
        String pedido = "";
        pedido += nombre.peek();
        pedido += ", " + producto.peek();
        pedido += ", " + precio.peek();
        System.out.println(pedido);
    }

    void historial() {
        for (int i = nombre.size() - 1; i >= 0; i--) {
            String pedido = "";
            pedido += nombre.get(i);
            pedido += ", " + producto.get(i);
            pedido += ", " + precio.get(i);
            System.out.println(pedido);
        }
    }

    public static void main(String [] arg){
        Scanner sc = new Scanner(System.in);
        Historial H = new Historial();

        while(true){
            System.out.println("Caferia -- Opciones(Registrar, Undo, Ultimo, Historial, Salir)");
            String input = sc.nextLine();

            if(input.equals("Registrar")){
                System.out.println("\nNonmbre:");
                String nombre = sc.nextLine();
                H.agregarCliente(nombre);

                System.out.println("\nProducto:");
                String producto = sc.nextLine();
                H.agregarProducto(producto);

                System.out.println("\nPrecio");
                String precio = sc.nextLine();
                H.agregarPrecio(precio);
            }

            if (input.equals("Undo")) {
                H.undo();
                continue;
            }

            if (input.equals("Ultimo")) {
                H.ultimo();
                continue;
            }

            if (input.equals("Historial")) {
                H.historial();
                continue;
            }

            if (input.equals("Salir")) {
                break;
            }
        }
        sc.close();
    }

}
