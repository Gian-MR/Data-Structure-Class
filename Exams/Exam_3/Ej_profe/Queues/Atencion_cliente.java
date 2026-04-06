package Exam_3.Ej_profe.Queues;

import java.util.*;

public class Atencion_cliente {
	public static void main(String[] args) {
		Queue<String> fila = new LinkedList<>(List.of("Cliente 1", "Cliente 2", "Cliente 3"));

		while (!fila.isEmpty()) {
			String actual = fila.poll();
			System.out.println("Atendiendo a " + actual);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}

		System.out.println("No hay mas llamadas.");
	}
}
