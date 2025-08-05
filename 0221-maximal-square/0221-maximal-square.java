class Solution {
    int max=0;
    public int maximalSquare(char[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                helper(matrix,i,j,dp);
            }
        }
        return max*max;
    }
    private int helper(char[][]matrix, int i, int j, int[][] dp){
        if(i>=matrix.length || j>=matrix[0].length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int sol=0;
        if(matrix[i][j]=='1'){
            int diag=helper(matrix,i+1,j+1,dp);
            int right=helper(matrix,i,j+1,dp);
            int bottom=helper(matrix,i+1,j,dp);
            sol=1+Math.min(diag,Math.min(right,bottom));
        }else{
            dp[i][j]=0;
        }
        max=Math.max(max,sol);
        return dp[i][j]=sol;
    }
}