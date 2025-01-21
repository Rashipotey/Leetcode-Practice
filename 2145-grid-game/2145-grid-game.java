class Solution {
    public long gridGame(int[][] grid) {
        long first=0;
        for(int n:grid[0]){
            first+=n;
        }
        long second=0;
        long minSum=Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            first-=grid[0][i];
            minSum=Math.min(minSum, Math.max(first,second));
            second+=grid[1][i];
        }
        return minSum;
    }
}