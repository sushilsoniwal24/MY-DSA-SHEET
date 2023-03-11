import java.util.ArrayList;

public class P_05_Remove_Duplicates_From_Sorted_Array {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

    // T.C = O(n) & S.C = O(n).
    public static int removeDuplicates1(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        int k = list.size();
        for (int i = 0; i < k; i++) {
            nums[i] = list.get(i);
        }
        return k;
    }

    // T.C = O(n) & S.C = O(1).
    public static int removeDuplicates2(int[] nums) {
        int length = nums.length;
        int currentIndex = 0, nextIndex = 1;

        while (nextIndex < length) {
            if (nums[currentIndex] != nums[nextIndex]) {
                nums[++currentIndex] = nums[nextIndex];
            }
            nextIndex++;
        }
        return currentIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates2(arr));
    }
}