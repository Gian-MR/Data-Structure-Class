package Exam_3.Ej_profe.Queues;

import java.util.*;

public class Generacion_binario {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = scanner.nextInt();

		if (n <= 0) {
			System.out.println("n must be greater than 0.");
			scanner.close();
			return;
		}

		Queue<String> queue = new LinkedList<>();
		queue.offer("1");

		System.out.println("Binary numbers from 1 to " + n + ":");
		for (int i = 1; i <= n; i++) {
			String current = queue.poll();
			System.out.println(current);

			queue.offer(current + "0");
			queue.offer(current + "1");
		}

		scanner.close();
	}
}
