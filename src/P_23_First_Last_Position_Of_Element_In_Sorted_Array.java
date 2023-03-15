public class P_23_First_Last_Position_Of_Element_In_Sorted_Array {

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

    // ? T.C = O(n) & S.C = O(1).
    public static int[] searchRange1(int[] nums, int target) {
        int[] res = {-1, -1};
        boolean first = false, second = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && !first) {
                res[0] = i;
                first = true;
            } else if (nums[i] == target && first) {
                res[1] = i;
                second = true;
            }
        }

        if (!second)
            res[1] = res[0];

        return res;
    }

    // * T.C = O(log n) & S.C = O(1).
    public static int[] searchRange2(int[] nums, int target){
        int n = nums.length;
        int[] res = {-1,-1};
        res[0] = search(nums,0,n-1,target,true);
        if(res[0]!=-1){
            res[1]=search(nums,0,n-1,target,false);
        }
        return res;
    }

    private static int search(int[] nums, int s, int e, int target, boolean isFirst) {
        int ans = -1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(nums[m]<target){
                s=m+1;
            }else if(nums[m]>target){
                e=m-1;
            }else{
                if (isFirst){
                    ans=m;
                    e=m-1;
                }else{
                    ans=m;
                    s=m+1;
                }
            }
        }
        return ans;
    }
}
