package Exam_3.Mock;

import java.util.*;

public class Fila_de_Clientes {
    Queue<String> fila = new LinkedList<>(List.of("Luis", "Maria", "Carlos", "Sofia"));
    int atendidos;

    void llegar(String n){
        fila.add(n);
    }
    void atender(){
        if(fila.isEmpty()){
            System.out.println("Fila esta vacia");
        }else{
            System.out.println(fila.poll());
            atendidos++;
        }
    }
    void siguiente(){
        if (fila.isEmpty()) {
            System.out.println("Fila esta vacia");
        } else {
            System.out.println(fila.peek());
        }
    }

    public static void main(String [] arg){
        Fila_de_Clientes F = new Fila_de_Clientes();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Fila: Opciones(Registrar, atender, siguiente, salir)");
            String input = sc.nextLine();

            if(input.equals("Registrar")){
                System.out.println("\nNombre:");
                String nombre = sc.nextLine();

                F.llegar(nombre);
                continue;
            }

            if(input.equals("atender")){
                F.atender();
            }

            if (input.equals("siguiente")) {
                F.siguiente();
            }

            if (input.equals("salir")) {
                break;
            }


        }

        sc.close();
    }
}
