class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][]dp=new int[s.length()][s.length()];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return helper(s,0,s.length()-1,dp);
    }
    private int helper(String s, int i, int n, int[][]dp){
        if(i>n) return 0;
        if(i==n) return 1;
        if(dp[i][n]!=-1) return dp[i][n];
        if(s.charAt(i)==s.charAt(n)){
            dp[i][n]=2+helper(s,i+1,n-1,dp);
        }else{
            dp[i][n]=Math.max(helper(s,i+1,n,dp), helper(s,i,n-1,dp));
        }
        return dp[i][n];
    }
}