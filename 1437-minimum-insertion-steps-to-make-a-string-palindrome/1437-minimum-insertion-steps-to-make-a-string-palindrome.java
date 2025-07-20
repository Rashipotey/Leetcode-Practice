class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int j=2;j<=n;j++){
            for(int i=0;i<=n-j;i++){
                int k=i+j-1;
                if(s.charAt(i)==s.charAt(k)){
                    dp[i][k]=dp[i+1][k-1]+2;
                }else{
                    dp[i][k]=Math.max(dp[i+1][k],dp[i][k-1]);
                }
            }
        }
        int lps=dp[0][n-1];
        return n-lps;
    }
}