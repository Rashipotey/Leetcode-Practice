class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int n=events.length;
        int dp[][]=new int[n][3];
        for(int[] d:dp) Arrays.fill(d,-1);
        return findMax(events,0,0,dp);
    }
    private int findMax(int[][] events, int i, int c, int[][] dp){
        if(c==2 || i>=events.length) return 0;
        if(dp[i][c]==-1){
            int end=events[i][1];
            int l=i+1, r=events.length-1;
            while(l<r){
                int m=l+(r-l)/2;
                if(events[m][0]>end) r=m;
                else l=m+1;
            }
            int take=events[i][2]+(l<events.length && events[l][0]>end? findMax(events,l,c+1,dp):0);
            int notTake=findMax(events,i+1,c,dp);
            dp[i][c]=Math.max(take,notTake);
        }
        return dp[i][c];
    }
}