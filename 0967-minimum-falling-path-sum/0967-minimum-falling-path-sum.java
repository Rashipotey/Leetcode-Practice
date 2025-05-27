class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int min=Integer.MAX_VALUE;
        int[][] dp=new int[n][n];
        //base case
        for(int i=0;i<n;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        //filling dp in bottom up manner
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int left=(j<=0)?Integer.MAX_VALUE:dp[i+1][j-1];
                int right=(j>=n-1)?Integer.MAX_VALUE:dp[i+1][j+1];
                dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],Math.min(right,left));
            }
        }
        //finding min in top row
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[0][i]);
        }
        return min;
    }
}