class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long dp[]=new long[n+1];
        for(int i=n-1;i>=0;i--){
            int points=questions[i][0];
            int brainPower=questions[i][1];
            long skip=dp[i+1]; //skip curr que
            int nextQ=i+brainPower+1; //solve curr que
            long solve=points+(nextQ<n?dp[nextQ]:0);
            dp[i]=Math.max(skip, solve);
        }
        return dp[0];
    }
}