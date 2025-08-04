class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(nums, nums.length-1, dp);
    }
    private int helper(int[] nums, int i, int dp[]){
        if(i==0) return 0;
        if(dp[i]!=-1) return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=0;j<i;j++){
            if(j+nums[j]>=i){
                int jumps=helper(nums,j,dp);
                if(jumps!=Integer.MAX_VALUE){
                    min=Math.min(min,jumps+1);
                }
            }
        }
        return dp[i]=min;
    }
}