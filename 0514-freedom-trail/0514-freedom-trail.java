class Solution {
    public int findRotateSteps(String ring, String key) {
        int dp[][]=new int[ring.length()][key.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(ring, key, 0, 0, dp);
    }
    private int helper(String ring, String key, int i, int j, int dp[][]){
        if(j==key.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=0;k<ring.length();k++){
            if(ring.charAt(k)==key.charAt(j)){
                int dist=Math.min(Math.abs(i-k), ring.length()-Math.abs(i-k));
                int steps=1+dist+helper(ring,key,k,j+1,dp);
                min=Math.min(min,steps);
            }
        }
        return dp[i][j]=min;
    }
}