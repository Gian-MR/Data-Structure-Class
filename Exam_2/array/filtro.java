package Exam_2.array;

import java.util.*;

public class filtro {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);

    void fill() {
        System.out.println("Enter 20 integers:");

        for (int i = 0; i < 20; i++) {
            try {
                numbers.add(sc.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter an integer:");
                sc.next(); // limpia el input incorrecto
                i--; // repite la misma posición
            }
        }
        System.out.println(numbers);
        sc.close();
    }

    // todo
    ArrayList<Integer> filter() {
        numbers.removeIf(x -> x < 60);
        System.out.println(numbers);
        return numbers;
    }
    
    // todo
    ArrayList<Integer> invert() {
        int left = 0, right = numbers.size() - 1, temp;

        while(left < right){
            temp = numbers.get(left);
            numbers.set(left, numbers.get(right));
            numbers.set(right, temp);
            left++;
            right--;
        }
        System.out.println(numbers);
        return numbers;
    }


    
    public static void main(String[] arg){
        filtro f = new filtro();

        f.fill();
        f.filter();
        f.invert();
    }
}
