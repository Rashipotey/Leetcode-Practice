class Solution {
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,prices,0,0);
    }
    private int helper(int[][] dp, int[] p, int i, int buy){
        if(i==p.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==0){
            profit=Math.max(0+helper(dp,p,i+1,0),-p[i]+helper(dp,p,i+1,1));
        }else{
            profit=Math.max(0+helper(dp,p,i+1,1), p[i]+helper(dp,p,i+1,0));
        }
        dp[i][buy]=profit;
        return profit;
    }
}