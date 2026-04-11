package Exam_4.Ej_prac.All;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class key_valueMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.print("How many pairs? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String key = sc.next(); // e.g. apple
            int value = sc.nextInt(); // e.g. 3
            map.put(key, value);
        }

        System.out.println(map);
        sc.close();
    }
}
