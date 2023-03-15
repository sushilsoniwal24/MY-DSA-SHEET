public class P_29_Number_Of_Rotations {

    // https://bit.ly/3dEvWJD

    // ? T.C = O(n) & S.C = O(1)
    public static int findKRotation1(int[] nums, int n) {
        int min_idx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[min_idx]) {
                min_idx = i;
            }
        }
        return min_idx;
    }

    // * T.C = O(log n) & S.C = O(1)
    public static int findKRotation2(int nums[], int n) {
        int s = 0, e = n - 1, m;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (m < e && nums[m] > nums[m + 1]) {
                return m + 1;
            } else if ((m > s) && nums[m - 1] > nums[m]) {
                return m;
            } else if (nums[s] <= nums[m]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return 0;
    }
}
