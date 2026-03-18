package Labs.Lab_2;
import java.util.Arrays;

public class TwoSumWrapper {

    public static int[] twoSum(int[] array, int targetSum) {

        //Code here
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        
        while(left < right){
            int sum = array[left] + array[right];
            if(sum > targetSum){
                right--;
            }else if(sum < targetSum){
                left++;
            }else {
                return new int[] { array[left], array[right] };
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        // Test case 1: Basic case with solution
        int[] test1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(test1, target1);
        System.out.println("Test 1: " + Arrays.toString(result1) + " (expected: [0, 1])");
        
        // Test case 2: Different target
        int[] test2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(test2, target2);
        System.out.println("Test 2: " + Arrays.toString(result2) + " (expected: [1, 2])");
        
        // Test case 3: Negative numbers
        int[] test3 = {-1, -2, -3, 5, 10};
        int target3 = 7;
        int[] result3 = twoSum(test3, target3);
        System.out.println("Test 3: " + Arrays.toString(result3) + " (expected: [2, 4])");
        
        // Test case 4: No solution
        int[] test4 = {1, 2, 3};
        int target4 = 10;
        int[] result4 = twoSum(test4, target4);
        System.out.println("Test 4: " + Arrays.toString(result4) + " (expected: null)");
        
        // Test case 5: Duplicate numbers
        int[] test5 = {3, 3};
        int target5 = 6;
        int[] result5 = twoSum(test5, target5);
        System.out.println("Test 5: " + Arrays.toString(result5) + " (expected: [0, 1])");
    }
}