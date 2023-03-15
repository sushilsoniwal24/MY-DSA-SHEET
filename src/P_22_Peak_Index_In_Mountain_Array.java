public class P_22_Peak_Index_In_Mountain_Array {

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

    // ? T.C = O(n) & S.C = O(1).
    public static int peakIndexInMountainArray1(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max])
                max = i;
        }
        return max;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static int peakIndexInMountainArray2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 5, 11, 6, 2};
        System.out.println(peakIndexInMountainArray2(arr));
    }
}
