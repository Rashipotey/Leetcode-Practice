class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length+1][nums.length];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return recursion(-1,0,nums,dp);
    }
    private int recursion(int prev, int curr, int[] nums, int[][]dp){
        if(curr==nums.length) return 0;
        if(dp[prev+1][curr]!=-1) return dp[prev+1][curr];
        int notTake=recursion(prev,curr+1,nums,dp);
        int take=0;
        if(prev==-1 || nums[prev]<nums[curr]){
            take=1+recursion(curr,curr+1,nums,dp);
        }
        return dp[prev+1][curr]=Math.max(take, notTake);
    }
}