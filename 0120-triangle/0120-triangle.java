class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n+1][n+1];
        for(int [] row:dp) Arrays.fill(row,-1);
        return helper(0,0,triangle,dp);
    }
    public int helper(int i,int j, List<List<Integer>> triangle, int dp[][]){
        if(i==triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=triangle.get(i).get(j)+Math.min(helper(i+1,j,triangle,dp),helper(i+1,j+1,triangle,dp));
        return dp[i][j];
    }
}