class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==1) dfs(grid,i,0);
            if(grid[i][m-1]==1) dfs(grid,i,m-1);
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==1) dfs(grid,0,i);
            if(grid[n-1][i]==1) dfs(grid,n-1,i);
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
    private void dfs(int[][]grid, int i, int j){
        grid[i][j]=2;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] d:dir){
            int x=d[0]+i, y=d[1]+j;
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length){
                if(grid[x][y]==1) dfs(grid,x,y);
            }
        }
    }
}