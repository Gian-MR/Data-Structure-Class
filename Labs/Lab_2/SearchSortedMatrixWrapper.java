package Labs.Lab_2;


import java.util.Arrays;

public class SearchSortedMatrixWrapper {

    public static int[] searchMatrix(int[][] matrix, int target) {
        /* ADD YOUR CODE HERE */
        int n_row = matrix.length, n_column = matrix[0].length;
        int row = 0, column = n_column -1;

        while (row < n_row && column >=0) {
            if(matrix[row][column] == target){
                return new int[] {row, column};
            }else if(matrix[row][column] > target){
                column--;
            }else{
                row++;
            }
        }
        return new int[] {-1,-1};
    }


    public static void main(String[] args) {
        // Test case 1: Basic 3x3 matrix with target found
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int target1 = 5;
        int[] result1 = searchMatrix(matrix1, target1);
        System.out.println("Test 1: " + Arrays.toString(result1) + " (expected: [1, 1])");

        // Test case 2: Target at top-left corner
        int[][] matrix2 = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };
        int target2 = 10;
        int[] result2 = searchMatrix(matrix2, target2);
        System.out.println("Test 2: " + Arrays.toString(result2) + " (expected: [0, 0])");

        // Test case 3: Target at bottom-right corner
        int[][] matrix3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int target3 = 9;
        int[] result3 = searchMatrix(matrix3, target3);
        System.out.println("Test 3: " + Arrays.toString(result3) + " (expected: [2, 2])");

        // Test case 4: Target not found
        int[][] matrix4 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int target4 = 100;
        int[] result4 = searchMatrix(matrix4, target4);
        System.out.println("Test 4: " + Arrays.toString(result4) + " (expected: [-1, -1])");

        // Test case 5: Single element matrix - target found
        int[][] matrix5 = {{42}};
        int target5 = 42;
        int[] result5 = searchMatrix(matrix5, target5);
        System.out.println("Test 5: " + Arrays.toString(result5) + " (expected: [0, 0])");

        // Test case 6: Single element matrix - target not found
        int[][] matrix6 = {{42}};
        int target6 = 10;
        int[] result6 = searchMatrix(matrix6, target6);
        System.out.println("Test 6: " + Arrays.toString(result6) + " (expected: [-1, -1])");

        // Test case 7: Negative numbers
        int[][] matrix7 = {
            {-5, -2, 0},
            {-1, 3, 5},
            {2, 4, 8}
        };
        int target7 = -1;
        int[] result7 = searchMatrix(matrix7, target7);
        System.out.println("Test 7: " + Arrays.toString(result7) + " (expected: [1, 0])");
    }

}
