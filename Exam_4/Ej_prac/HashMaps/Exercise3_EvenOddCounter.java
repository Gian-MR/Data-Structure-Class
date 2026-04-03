package Exam_4.Ej_prac.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class Exercise3_EvenOddCounter {

    public static Map<String, Integer> countEvenOdd(int[] nums) {
        // Instructions:
        // 1. Create a HashMap<String, Integer>.
        // 2. Put the keys "even" and "odd" with starting value 0.
        // 3. Loop through the array.
        // 4. If the number is divisible by 2, increase "even".
        // 5. Otherwise, increase "odd".
        // 6. Return the map.

        // ADD CODE HERE
        HashMap<String, Integer> countMap = new HashMap<>();
        countMap.put("even", 0);
        countMap.put("odd", 0);
        for (int num : nums) {
            if (num % 2 == 0) {
                countMap.put("even", countMap.get("even") + 1);
            } else {
                countMap.put("odd", countMap.get("odd") + 1);
            }
        }
        //* Another way to update a counter:
        //* countMap.merge("even", 1, Integer::sum);
        return countMap;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 7, 10, 3, 8, 1 };
        System.out.println(countEvenOdd(nums));
        // Expected idea:
        // {even=3, odd=3}
    }
}
