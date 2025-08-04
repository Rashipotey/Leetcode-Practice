class Solution {
    public int numDecodings(String s) {
        if(s.startsWith("0")) return 0;
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,0,dp); 
    }
    private int helper(String r, int i, int[]dp){
        if(i==r.length()) return 1;
        if(r.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int ways=helper(r,i+1,dp);
        if(i+1<r.length()){
            int n=(r.charAt(i)-'0')*10+(r.charAt(i+1)-'0');
            if(n>=1 && n<=26){
                ways+=helper(r,i+2,dp);
            }
        }
        return dp[i]=ways;
    }
}