class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int [] dp=new int[nums.length];
        int [] dp1=new int[nums.length];
        Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);
        return Math.max(recursion(0, n-2, nums, dp),recursion(1, n-1, nums,dp1));
    }
    public int recursion(int i, int n, int [] nums, int[] dp){
        if(i>n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int rob=nums[i]+recursion(i+2, n, nums, dp);
        int skip=recursion(i+1, n, nums, dp);
        dp[i]=Math.max(rob, skip);
        return dp[i];
    }
}