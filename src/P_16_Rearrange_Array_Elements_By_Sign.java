import java.util.Arrays;

public class P_16_Rearrange_Array_Elements_By_Sign {

    // https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

    // ? T.C = O(n) & S.C = O(n).
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int positive = 0, negative = 1;

        for (int num : nums) {
            if (num > 0) {
                res[positive] = num;
                positive += 2;
            } else {
                res[negative] = num;
                negative += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] res = rearrangeArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
