class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][]=new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(dp, prices, 0, 0, 2);
    }
    private int helper(int[][][] dp, int[] p, int i, int buy, int rem){
        if(i==p.length || rem==0) return 0;
        if(dp[i][buy][rem]!=-1) return dp[i][buy][rem];
        int profit;
        if(buy==0){
            profit=Math.max(0+helper(dp,p,i+1,0,rem), -p[i]+helper(dp,p,i+1,1,rem));
        }else{
            profit=Math.max(0+helper(dp,p,i+1,1,rem), p[i]+helper(dp,p,i+1,0,rem-1));
        }
        return dp[i][buy][rem]=profit;
    }
}