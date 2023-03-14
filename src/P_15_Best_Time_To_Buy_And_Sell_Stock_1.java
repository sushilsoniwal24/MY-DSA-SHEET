public class P_15_Best_Time_To_Buy_And_Sell_Stock_1 {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    // ? T.C = O(n^2) & S.C = O(1).
    public static int maxProfit1(int[] nums) {
        int n = nums.length;
        int profit = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] > profit) {
                    profit = nums[j] - nums[i];
                }
            }
        }
        return profit;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int maxProfit2(int[] nums) {
        int minsofar = Integer.MAX_VALUE;
        int profit = 0, sell = 0;
        for (int num : nums) {
            if (num < minsofar) {
                minsofar = num;
            }
            sell = num - minsofar;
            if (sell > profit) {
                profit = sell;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(nums));
    }
}
