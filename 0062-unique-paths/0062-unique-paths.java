class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return helper(0,0,n,m,dp);
    }
    public int helper(int i, int j, int n, int m, int[][] dp){
        if(i==n-1 && j==m-1) return 1;
        if(i>=n || j>=m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=helper(i+1,j,n,m,dp)+helper(i,j+1,n,m,dp);
        return dp[i][j];
    }
}