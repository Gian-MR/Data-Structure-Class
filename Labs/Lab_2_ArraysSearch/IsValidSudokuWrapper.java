package Labs.Lab_2_ArraysSearch;
public class IsValidSudokuWrapper {
    public static boolean isValidSudoku(char[][] board) {
        /* ADD YOUR CODE HERE */

        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][] boxs = new boolean[9][10];

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char character = board[row][col];
                if (character == '.') continue;

                int digit = character - '0';
                if(digit < 1 || digit > 9) return false;

                int boxIndex = (row / 3) * 3 + (col / 3); 

                if (rows[row][digit] || columns[col][digit] || boxs[boxIndex][digit]) {
                return false;
            }

                rows[row][digit] = true;
                columns[col][digit] = true;
                boxs[boxIndex][digit] = true;
            }
        }
        return true;
    }
}