package Exam_1.Scanner_Classes;
import java.util.Scanner;

public class Edades {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int estudiantes = 50;
        int suma = 0;

        for (int i = 0; i < estudiantes; i++) {

            int edad;

            while (true) {

                System.out.print("Edad de estudiante #" + (i + 1) + ": ");
                String input = sc.nextLine();

                try {
                    edad = Integer.parseInt(input);

                    if (edad < 0) {
                        System.out.println("Edad no puede ser negativa.");
                        continue;
                    }

                    break; // valid number
                }
                catch (NumberFormatException e) {
                    System.out.println("Solo numeros por favor.");
                }
            }

            suma += edad;
        }

        double promedio = (double) suma / estudiantes;

        System.out.println("El promedio es: " + promedio);

        sc.close();
    }
}