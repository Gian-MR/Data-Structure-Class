package Exam_3.Ej_profe.Stacks;

import java.util.*;

public class Undos {
	private final Stack<String> acciones = new Stack<>();

	public void escribir(String texto) {
		acciones.push(texto);
		System.out.println("Estado actual: " + estadoActual());
	}

	public void undo() {
		if (acciones.isEmpty()) {
			System.out.println("No hay acciones para deshacer.");
			return;
		}

		String ultimaAccion = acciones.pop();
		System.out.println("Se borro: " + ultimaAccion);
		System.out.println("Estado actual: " + estadoActual());
	}

	public String estadoActual() {
		StringBuilder estado = new StringBuilder();
		for (String accion : acciones) {
			estado.append(accion);
		}
		return estado.toString();
	}

	public static void main(String[] args) {
		Undos editor = new Undos();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Editor simple con undo");
		System.out.println("Comandos:");
		System.out.println("1) write: <texto>");
		System.out.println("2) undo");
		System.out.println("3) exit");

		while (true) {
			System.out.print("> ");
			String linea = scanner.nextLine();

			if (linea.equalsIgnoreCase("exit")) {
				break;
			}

			if (linea.equalsIgnoreCase("undo")) {
				editor.undo();
				continue;
			}

			if (linea.toLowerCase().startsWith("write ")) {
				String texto = linea.substring(7);
				editor.escribir(texto);
				continue;
			}

			System.out.println("Comando no valido. Usa: write <texto>, undo o exit.");
		}

		scanner.close();
	}
}
