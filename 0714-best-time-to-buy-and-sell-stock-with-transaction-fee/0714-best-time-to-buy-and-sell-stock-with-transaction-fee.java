class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][]=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(dp,prices,0,0, fee);
    }
    private int helper(int[][] dp, int[] p, int i, int buy, int fee){
        if(i==p.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit;
        if(buy==0){
            profit=Math.max(helper(dp,p,i+1,0, fee), -p[i]+helper(dp,p,i+1,1, fee));
        }else{
            profit=Math.max(helper(dp,p,i+1,1, fee), p[i]+helper(dp,p,i+1,0, fee)-fee);
        }
        return dp[i][buy]=profit;
    }
}