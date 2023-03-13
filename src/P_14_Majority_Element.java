import java.util.Arrays;
import java.util.HashMap;

public class P_14_Majority_Element {

    // https://leetcode.com/problems/majority-element/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static int majorityElement1(int[] nums) {
        int n = nums.length, count = 0;
        for (int num : nums) {
            for (int i : nums) {
                if (num == i)
                    count++;
            }
            if (count > n / 2) {
                return num;
            } else {
                count = 0;
            }
        }
        return n;
    }

    // * T.C = O(nlogn) & S.C = O(1).
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // ! T.C = O(n) & S.C = O(n).
    public static int majorityElement3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int majorityCount = nums.length / 2;
        for (int key : map.keySet()) {
            if (map.get(key) > majorityCount)
                return key;
        }
        return -1;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int majorityElement4(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement4(nums));
    }
}
