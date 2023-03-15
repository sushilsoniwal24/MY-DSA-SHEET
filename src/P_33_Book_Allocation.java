public class P_33_Book_Allocation {

    // https://bit.ly/3QMrMxP

    // ! T.C = O(n*log(n)) & S.C = O(1).
    public static int findPages(int[] books, int n, int students) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int pages : books) {
            sum += pages;
            if (pages > max) {
                max = pages;
            }
        }

        if (n < students) {
            return -1;
        }

        int low = max, high = sum, mid, ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isPossibleToAllocate(books, mid, students)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossibleToAllocate(int[] books, int mid, int students) {
        int currentSum = 0, numStudents = 1;
        for (int pages : books) {
            currentSum += pages;
            if (currentSum > mid) {
                numStudents++;
                currentSum = pages;
            }
        }
        return (numStudents <= students);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(findPages(arr, arr.length, 3));
    }
}
