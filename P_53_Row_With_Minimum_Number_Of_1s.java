public class P_53_Row_With_Minimum_Number_Of_1s {

    // https://bit.ly/3Tn6rO2

    // ? T.C = O(n*m) & S.C = O(n).
    public static int minRow1(int n, int m, int[][] mat) {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1)
                    ones++;
            }
            temp[i] = ones;
        }
        int min_row = 0, min = Integer.MAX_VALUE;
        ;
        for (int i = 0; i < n; i++) {
            if (temp[i] < min) {
                min = temp[i];
                min_row = i + 1;
            }
        }
        return min_row;
    }

    // * T.C = O(n*m) & S.C = O(1).
    public static int minRow2(int n, int m, int arr[][]) {
        int min = Integer.MAX_VALUE, minRow = 0;
        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    ones++;
                }
            }
            if (ones < min) {
                min = ones;
                minRow = i;
            }
        }
        return minRow + 1;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };
        System.out.println(minRow2(mat.length, mat[0].length, mat));
    }
}
