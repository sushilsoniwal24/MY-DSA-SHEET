public class P_30_Koko_Eating_Bananas {

    // https://leetcode.com/problems/koko-eating-bananas/description/

    // ! T.C = O(N*log(max(Piles))) & S.C = O(1).
    public static int minEatingSpeed(int[] piles, int h) {
        // Find the maximum pile size
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            if (p > max)
                max = p;
        }

        // If we have as many hours as piles, return the max pile size
        if (h == piles.length) {
            return max;
        }

        // Perform a binary search to find the minimum eating speed
        int low = 1;
        int high = max;
        int k = Integer.MAX_VALUE;
        while (low <= high) {
            int speed = low + (high - low) / 2;
            if (isPossible(piles, h, speed)) {
                k = speed;
                high = speed - 1;
            } else {
                low = speed + 1;
            }
        }

        // Return the minimum eating speed
        return k;
    }

    private static boolean isPossible(int[] piles, int h, int speed) {
        // Calculate the total time required to eat all the piles
        long time = 0;
        for (int pile : piles) {
            time += pile / speed;
            if (pile % speed != 0) {
                time++;
            }
        }

        // Check if the total time is less than or equal to the given number of hours
        return (time <= h);
    }


    public static void main(String[] args) {
        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;
        System.out.println(minEatingSpeed(piles, h));
    }
}
