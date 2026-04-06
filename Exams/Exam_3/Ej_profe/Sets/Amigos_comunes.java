package Exam_3.Ej_profe.Sets;

import java.util.*;

public class Amigos_comunes {
	public static void main(String[] args) {
		Set<String> amigosA = new HashSet<>(List.of("Ana", "Luis", "Marta","Carlos"));
		Set<String> amigosB = new HashSet<>(List.of("Luis", "Sofia", "Carlos", "Pedro"));

		Set<String> comunes = new HashSet<>(amigosA);
		comunes.retainAll(amigosB);

		System.out.println("Amigos del Usuario A: " + amigosA);
		System.out.println("Amigos del Usuario B: " + amigosB);
		System.out.println("Amigos comunes: " + comunes);
	}
}
