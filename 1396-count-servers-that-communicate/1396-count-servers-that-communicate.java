class Solution {
    public int countServers(int[][] grid) {
        int row[]=new int[grid.length];
        int col[]=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                row[i]+=grid[i][j];
                col[i]+=grid[j][i];
            }
        }
        int ans=0;
        for(int i=0;i<row.length;i++){
            for(int j=0;j<col.length;j++){
                if(grid[i][j]==1 && (row[i]>1 || col[j]>1)){
                    ans++;
                }
            }
        }
        return ans;
    }
}