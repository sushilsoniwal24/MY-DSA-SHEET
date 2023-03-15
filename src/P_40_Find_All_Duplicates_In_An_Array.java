import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P_40_Find_All_Duplicates_In_An_Array {

    // https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

    // ? T.C = O(n^2) & S.C = O(1) {TLE}.
    public static List<Integer> findDuplicates1(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j])
                    res.add(arr[i]);
            }
        }
        return res;
    }

    // * T.C = O(n) & S.C = O(n)
    public static List<Integer> findDuplicates2(int[] arr) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                res.add(num);
            } else {
                set.add(num);
            }
        }
        return res;
    }

    // ! T.C = O(n) & S.C = O(1).
    public static List<Integer> findDuplicates3(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        int i = 0, n = arr.length;
        while (i < n) {
            int correct_idx = arr[i] - 1;
            if (arr[i] != arr[correct_idx]) {
                int temp = arr[i];
                arr[i] = arr[correct_idx];
                arr[correct_idx] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] != j + 1)
                duplicates.add(arr[j]);
        }
        return duplicates;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates3(arr));
    }
}
