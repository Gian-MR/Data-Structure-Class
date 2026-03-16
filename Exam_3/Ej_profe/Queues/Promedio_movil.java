package Exam_3.Ej_profe.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Promedio_movil {
	private final Queue<Integer> queue = new LinkedList<>();
	private final int k;
	private int suma = 0;

	public Promedio_movil(int k) {
		this.k = k;
	}

	public double agregar(int n) {
		queue.offer(n);
		suma += n;

		if (queue.size() > k) {
			suma -= queue.poll();
		}

		return suma / queue.size();
	}

	public static void main(String[] args) {
		Promedio_movil pm = new Promedio_movil(3);

		System.out.println(pm.agregar(10));
		System.out.println(pm.agregar(20));
		System.out.println(pm.agregar(30));
		System.out.println(pm.agregar(40));
	}
}
