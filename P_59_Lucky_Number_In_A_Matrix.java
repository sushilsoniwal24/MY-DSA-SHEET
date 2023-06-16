import java.util.ArrayList;
import java.util.List;

public class P_59_Lucky_Number_In_A_Matrix {

    // https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/

    // ! T.C = O(m*n) & S.C = O(m).
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            int minColIndex = findMinInRow(matrix, row);
            int minVal = matrix[row][minColIndex];

            if (isMaxInCol(matrix, minColIndex, minVal)) {
                ans.add(minVal);
            }
        }

        return ans;
    }

    // * Find the index of the minimum value in the given row of the matrix.
    private static int findMinInRow(int[][] matrix, int row) {
        int min_idx = 0;
        int min_val = matrix[row][min_idx];
        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] < min_val) {
                min_val = matrix[row][col];
                min_idx = col;
            }
        }
        return min_idx;
    }

    // * Checks if the given value is the maximum value in its column.
    private static boolean isMaxInCol(int[][] matrix, int col, int val) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] > val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
        System.out.println(luckyNumbers(matrix));
    }
}
