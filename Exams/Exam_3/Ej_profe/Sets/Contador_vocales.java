package Exam_3.Ej_profe.Sets;

import java.util.*;

public class Contador_vocales {
    Set<Character> vocales = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
    String texto = "Esta manana sali temprano de casa para comprar pan, pero en el camino me encontre con un perro durmiendo junto a una bicicleta azul. El cielo estaba nublado, las calles casi vacias y una senora cantaba mientras regaba las plantas de su balcon. Al final llegue a la tienda, compre jugo y galletas, y regrese pensando en lo raro y tranquilo que habia sido todo.";

    void contarVocalesUnicas() {
        Set<Character> usadas = new HashSet<>();

        for (int i = 0; i < texto.length(); i++) {
            char letra = Character.toLowerCase(texto.charAt(i));

            if (vocales.contains(letra)) {
                usadas.add(letra);
            }
        }

        System.out.println("Vocales usadas: " + usadas);
        System.out.println("Cantidad de vocales unicas: " + usadas.size());
    }

    public static void main(String[] args) {
        Contador_vocales c = new Contador_vocales();
        c.contarVocalesUnicas();
    }
}

