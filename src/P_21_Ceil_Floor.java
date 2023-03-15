public class P_21_Ceil_Floor {

    // ? T.C = O(log n) & S.C = O(1).
    public static int ceil(int[] nums, int target) {
        // ! Ceil:- Smallest element >= target.
        int n = nums.length;
        int s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[m] < target)
                s = m + 1;
            else
                e = m - 1;
        }
        return s;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static int floor(int[] nums, int target) {
        // ! Floor:- Largest element <= target.
        int n = nums.length;
        int s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[m] < target)
                s = m + 1;
            else
                e = m - 1;
        }
        return e;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        System.out.println(ceil(arr, 15));
        System.out.println(floor(arr, 15));
    }
}
