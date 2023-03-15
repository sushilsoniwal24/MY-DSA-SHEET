import java.util.HashMap;

public class P_38_First_Missing_Positive {

    // https://leetcode.com/problems/first-missing-positive/description/

    // ? T.C = O(n) & S.C = O(n).
    public static int firstMissingPositive1(int[] nums) {
        int length = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
        }

        for (int i = 1; i < length; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1)
                return j + 1;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, -1, 1 };
        System.out.println(firstMissingPositive2(arr));
    }
}
