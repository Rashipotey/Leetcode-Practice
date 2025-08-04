class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=1;
        }
        for(int j=2;j<=n;j++){
            int total=0;
            for(int k=1;k<=j;k++){
                total+=dp[k-1]*dp[j-k];
            }
            dp[j]=total;
        }
        return dp[n];
    }
}