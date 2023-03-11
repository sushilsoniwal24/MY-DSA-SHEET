import java.util.Arrays;
import java.util.HashMap;

public class P_06_Two_Sum {

    // https://leetcode.com/problems/two-sum/description/

    // T.C = O(n^2) & S.C = O(1).
    public static int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // T.C = O(n) & S.C = O(n).
    public static int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current_num = nums[i];
            int req_num = target - current_num;
            if (map.containsKey(req_num)) {
                return new int[]{i, map.get(req_num)};
            } else {
                map.put(current_num, i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] res = twoSum2(arr, 18);
        System.out.println(Arrays.toString(res));
    }
}