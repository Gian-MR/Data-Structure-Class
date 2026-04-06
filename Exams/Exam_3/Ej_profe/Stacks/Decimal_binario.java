package Exam_3.Ej_profe.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Decimal_binario {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();

		System.out.print("Ingresa un numero decimal: ");
		int numero = scanner.nextInt();
		int n = numero;

		if (n == 0) {
			System.out.println("Binario: 0");
			scanner.close();
			return;
		}

		while (n > 0) {
			stack.push(n % 2);
			n = n / 2;
		}

		System.out.print("Binario: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();

		scanner.close();
	}
}
