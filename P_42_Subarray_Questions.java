public class P_42_Subarray_Questions {

    // ? Q-01:- Print All The Subarrays Of A Given Array.
    public static void printAllSubarrays(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    // ? Q-02:- Print The Sum Of All The Subarrays Of A Given Array.
    public static void printAllSubarraySum(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                System.out.println(sum);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        printAllSubarrays(arr);
        printAllSubarraySum(arr);
    }
}
