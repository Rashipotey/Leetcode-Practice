class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int [] row:dp) Arrays.fill(row,-1);
        return helper(n-1,m-1,grid,dp);
    }
    public int helper(int i, int j, int [][] grid, int[][] dp){
       if(i==0 && j==0) return grid[i][j];
       if(i<0 || j<0) return Integer.MAX_VALUE;
       if(dp[i][j]!=-1) return dp[i][j];
       dp[i][j]=grid[i][j]+Math.min(helper(i-1,j,grid,dp),helper(i,j-1,grid,dp));
       return dp[i][j];
    }
}