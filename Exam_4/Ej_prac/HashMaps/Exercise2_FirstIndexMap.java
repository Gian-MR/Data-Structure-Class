package Exam_4.Ej_prac.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class Exercise2_FirstIndexMap {

    public static Map<String, Integer> firstIndexMap(String[] words) {
        // Instructions:
        // 1. Create a HashMap<String, Integer>.
        // 2. Traverse the array using an index i.
        // 3. If a word is NOT already in the map, store:
        //       word -> i
        // 4. If the word is already there, do nothing.
        // 5. Return the map.

        //ADD CODE HERE
        return null;
    }

    public static void main(String[] args) {
        String[] words = { "apple", "banana", "apple", "orange", "banana", "grape" };
        System.out.println(firstIndexMap(words));
        // Expected idea:
        // {apple=0, banana=1, orange=3, grape=5}
    }
}
