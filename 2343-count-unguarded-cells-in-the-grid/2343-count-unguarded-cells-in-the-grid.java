class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid=new char[m][n];
        for(int[]g:guards){
            grid[g[0]][g[1]]='G';
        }
        for(int[]w:walls){
            grid[w[0]][w[1]]='W';
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!='G' && grid[i][j]!='W') grid[i][j]='.';
            }
        }
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        for(int[]g:guards){
            int r=g[0], c=g[1];
            for(int[]d:dir){
                int i=r+d[0], j=c+d[1];
                while(i>=0 && i<m && j>=0 && j<n){
                    if(grid[i][j]=='G' || grid[i][j]=='W') break;
                    if(grid[i][j]=='.') grid[i][j]='X';
                    i+=d[0];
                    j+=d[1];
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='.') count++;
            }
        }
        return count;
    }
}