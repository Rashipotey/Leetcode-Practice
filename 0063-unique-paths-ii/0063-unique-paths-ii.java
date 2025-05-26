class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[n-1][m-1]==1) return 0;
        int dp[][]=new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return helper(0,0,n,m,dp, obstacleGrid);
    }
    public int helper(int i, int j, int n, int m, int[][] dp, int[][] obs){
        if(i==n-1 && j==m-1) return obs[i][j]==1?0:1;
        if(i>=n || j>=m) return 0;
        if(obs[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=helper(i+1,j,n,m,dp,obs)+helper(i,j+1,n,m,dp,obs);
        return dp[i][j];
    }
}