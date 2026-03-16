package Exam_3.Ej_profe.Sets;

import java.util.*;

public class Diferencia {
	public static void main(String[] args) {
		Set<String> tareasAsignadas = new HashSet<>(List.of("Investigar tema", "Hacer resumen", "Resolver ejercicios", "Subir tarea"));
		Set<String> tareasCompletadas = new HashSet<>(List.of("Investigar tema", "Resolver ejercicios"));

		Set<String> tareasPendientes = new HashSet<>(tareasAsignadas);
		tareasPendientes.removeAll(tareasCompletadas);

		System.out.println("Tareas pendientes: " + tareasPendientes);
	}
}
