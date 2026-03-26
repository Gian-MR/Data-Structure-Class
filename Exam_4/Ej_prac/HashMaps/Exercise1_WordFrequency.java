package Exam_4.Ej_prac.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class Exercise1_WordFrequency {

    public static Map<String, Integer> wordFrequency(String[] words) {
        // Instructions:
        // 1. Create a HashMap<String, Integer> to store each word and its count.
        // 2. Go through the array one word at a time.
        // 3. If the word is not in the map, add it with value 1.
        // 4. If the word is already in the map, increase its count by 1.
        // 5. Return the completed map.

        //ADD CODE HERE
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        String[] words = { "cat", "dog", "cat", "bird", "dog", "cat" };
        System.out.println(wordFrequency(words));
        // Expected idea:
        // {cat=3, dog=2, bird=1}
    }
}
