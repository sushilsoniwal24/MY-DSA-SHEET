import java.util.HashMap;

public class P_43_Subarray_Sum_Equals_K {

    // https://leetcode.com/problems/subarray-sum-equals-k/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static int subarraySum1(int[] arr, int k) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    // * T.C = O(n) & S.C = O(n).
    public static int subarraySum(int[] arr, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int j : arr) {
            sum += j;
            if (preSum.containsKey(sum - k)) {
                count += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 6 };
        System.out.println(subarraySum(arr, 5));
    }
}
