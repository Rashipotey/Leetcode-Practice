class Solution {
    public int rob(int[] nums) {
        int [] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return recursion(0, nums, dp);
    }
    public int recursion(int i, int [] nums, int[] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int rob=nums[i]+recursion(i+2,nums, dp);
        int skip=recursion(i+1, nums, dp);
        dp[i]=Math.max(rob, skip);
        return dp[i];
    }
}