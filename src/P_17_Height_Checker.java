import java.util.Arrays;

public class P_17_Height_Checker {

    // https://leetcode.com/problems/height-checker/

    // ? T.C = O(nlogn) & S.C = O(n).
    public static int heightChecker(int[] nums) {
        int n = nums.length, c = 0;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            if (temp[i] != nums[i]) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3, 1};
        System.out.println(heightChecker(nums));
    }
}
