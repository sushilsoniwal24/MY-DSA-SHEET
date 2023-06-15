import java.util.Arrays;

public class P_51_Matrix_Basics {

    // Todo:- Print the sum of a given 2-D matrix.
    public static int calculateSum(int[][] mat) {
        int sum = 0;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                sum += mat[row][col];
            }
        }
        return sum;
    }

    // Todo:- Return the minimum & maximum element of a given 2-D matrix.
    public static int[] findMinMax(int[][] mat) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                int num = mat[row][col];
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
        }

        return new int[] { min, max };
    }

    public static void main(String[] args) {
        int[][] mat = { { 6, 2, 5 }, { 9, 4 }, { 1, 7, 8, 3 } };
        System.out.println(calculateSum(mat));

        System.out.println(Arrays.toString(findMinMax(mat)));
    }
}
