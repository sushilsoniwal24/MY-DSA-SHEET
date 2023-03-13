import java.util.Arrays;

public class P_13_Sort_Colors {

    // https://leetcode.com/problems/sort-colors/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static void sortColors1(int[] nums) {
        int n = nums.length;

        // Outer Loop For No. Of Passes.
        for (int pass = 0; pass < n - 1; pass++) {
            boolean isSwapped = false;

            // Inner Loop For Comparison & Swapping
            for (int idx = 0; idx < n - pass - 1; idx++) {
                // Check For Wrong Order.
                if (nums[idx] > nums[idx + 1]) {
                    int temp = nums[idx];
                    nums[idx] = nums[idx + 1];
                    nums[idx + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped)
                break; // Array Is Sorted, No Need To Check Again.
        }
    }

    // * T.C = O(nlogn) & S.C = O(1).
    public static void sortColors2(int[] nums) {
        Arrays.sort(nums);
    }

    // ! T.C = O(n) & S.C = O(1).
    public static void sortColors3(int[] nums) {
        int n = nums.length, idx = 0;
        int zeros = 0, ones = 0;
        for (int num : nums) {
            if (num == 0) zeros++;
            if (num == 1) ones++;
        }
        while (zeros > 0) {
            nums[idx++] = 0;
            zeros--;
        }
        while (ones > 0) {
            nums[idx++] = 1;
            ones--;
        }
        while (idx < n) {
            nums[idx++] = 2;
        }
    }

    // * T.C = O(n) & S.C = O(1).
    public static void sortColors4(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1, temp;
        while (mid <= high) {
            switch (nums[mid]) {
                // If nums[mid] == 0, swap nums[low] & nums[mid] and increment both low & mid
                case 0 -> {
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                }

                // We keep incrementing mid as long as nums[mid] == 1.
                case 1 -> mid++;

                // If nums[mid] == 2, we swap nums[mid] and nums[high] and decrement high.
                case 2 -> {
                    temp = nums[high];
                    nums[high] = nums[mid];
                    nums[mid] = temp;
                    high--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
