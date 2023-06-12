import java.util.HashSet;

public class P_32_Kth_Missing_Positive_Number {

    // https://leetcode.com/problems/kth-missing-positive-number

    // ? T.C = O(n) & S.C = O(n)
    public static int findKthPositive1(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > max)
                max = a;
        }
        max += k;

        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) {
            set.add(a);
        }

        int ans = 0, i = 1;
        while (k != 0) {
            if (!set.contains(i)) {
                ans = i;
                k--;
            }
            i++;
        }
        return ans;
    }

    // * T.C = O(log n) & S.C = O(1)
    public static int findKthPositive2(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - mid - 1;
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low + k;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 9, 15 };
        System.out.println(findKthPositive2(arr, 8));
    }
}
