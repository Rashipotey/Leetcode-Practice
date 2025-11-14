class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][]pSum=new int[n+1][n+1];
        for(int [] q:queries){
            int rl=q[0], cl=q[1], rr=q[2], cr=q[3];
            pSum[rl][cl]++;
            if(cr+1<n) pSum[rl][cr+1]--;
            if(rr+1<n) pSum[rr+1][cl]--;
            if(rr+1<n && cr+1<n) pSum[rr+1][cr+1]++;
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                pSum[i][j]+=pSum[i][j-1];
            }
        }
        for(int j=0;j<n;j++){
            for(int i=1;i<n;i++){
                pSum[i][j]+=pSum[i-1][j];
            }
        }
        int[][]res=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[i][j]=pSum[i][j];
            }
        }
        return res;
    }
}