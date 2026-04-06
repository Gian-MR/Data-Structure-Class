package Exam_3.Ej_profe.Sets;

import java.util.HashSet;
import java.util.Set;

public class Buscar_duplicados {
    Set<Integer> unico = new HashSet<>();
    int[] numeros = {
            4, 7, 12, 9, 15,
            4, 7, 12, 9, 15,
            22, 31, 18, 26, 33,
            22, 31, 18, 26, 33,
            5, 14, 5, 14,
            99
    };

    void unico(){
        for (int i : numeros) {
            if (unico.contains(i)) {
                unico.remove(i);
            } else {
                unico.add(i);
            }
        }
        System.out.println("Numero unico: " + unico);
    }

    public static void main(String[] arg){
        Buscar_duplicados B = new Buscar_duplicados();

        B.unico();
    }
}
