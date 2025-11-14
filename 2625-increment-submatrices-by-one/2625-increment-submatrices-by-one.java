class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][]res=new int[n][n];
        for(int [] q:queries){
            int rl=q[0], cl=q[1], rr=q[2], cr=q[3];
            for(int i=rl;i<=rr && i>=0 && i<n;i++){
                for(int j=cl;j<=cr && j>=0 && j<n;j++){
                    res[i][j]++;
                }
            }
        }
        return res;
    }
}