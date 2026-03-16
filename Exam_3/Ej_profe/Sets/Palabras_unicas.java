package Exam_3.Ej_profe.Sets;

import java.util.*;

public class Palabras_unicas {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Escribe un parrafo:");
		String texto = scanner.nextLine().toLowerCase();

		texto = texto.replaceAll("[^a-z0-9\\s]", " ");

		String[] palabras = texto.trim().split("\\s+");
		Set<String> unicas = new HashSet<>();

		for (String p : palabras) {
			if (!p.isEmpty()) {
				unicas.add(p);
			}
		}

		System.out.println("Cantidad de palabras unicas: " + unicas.size());

		scanner.close();
        // Esta manana sali temprano de casa para comprar pan, pero en el camino me
        // encontre con un perro durmiendo junto a una bicicleta azul. El cielo estaba
        // nublado, las calles casi vacias y una senora cantaba mientras regaba las
        // plantas de su balcon. Al final llegue a la tienda, compre jugo y galletas, y
        // regrese pensando en lo raro y tranquilo que habia sido todo.
	}
}
