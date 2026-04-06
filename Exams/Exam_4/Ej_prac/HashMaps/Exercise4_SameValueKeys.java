package Exam_4.Ej_prac.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise4_SameValueKeys {

    public static List<String> keysWithValue(Map<String, Integer> map, int targetValue) {
        // Instructions:
        // 1. Create an ArrayList<String> for the answer.
        // 2. Go through every key in the map.
        // 3. Check the value associated with that key.
        // 4. If the value equals targetValue, add the key to the list.
        // 5. Return the list.

        //ADD CODE HERE
        List<String> keysList = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == targetValue) {
                keysList.add(key);
            }
        }
        return keysList;
    }

    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Ana", 90);
        grades.put("Luis", 85);
        grades.put("Mia", 90);
        grades.put("Joel", 70);

        System.out.println(keysWithValue(grades, 90));
        // Expected idea:
        // [Ana, Mia]
    }
}
