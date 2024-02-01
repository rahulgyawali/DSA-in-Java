package Leetcode.DP;

public class HouseRobberII {

    public static int f(int[] nums,int n){
        int prev1 = nums[0];
        int prev2 = 0;
        int curr = prev1;
        for(int i = 1 ;i < n; i++){
            int take = nums[i];
            if(i > 1){
                take+=prev2;
            }
            int notTake = prev1;
            curr = Math.max(take,notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int[] a = new int [n-1];
        int[] b = new int [n-1];
        for(int i = 0; i < n-1; i++){
            a[i] = nums[i];
        }
        for(int i = 1; i < n; i++){
            b[i-1] = nums[i];
        }

        return Math.max(f(a,n-1),f(b,n-1));
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,1};
        int maxVal = rob(arr);
        System.out.println(maxVal);
    }


}
