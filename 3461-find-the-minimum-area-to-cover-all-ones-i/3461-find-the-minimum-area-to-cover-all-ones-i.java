class Solution {
    public int minimumArea(int[][] grid) {
        int fr=1001, lr=-1, fc=1001, lc=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    fr=Math.min(fr,i);
                    lr=Math.max(lr,i);
                    fc=Math.min(fc,j);
                    lc=Math.max(lc,j);
                }
            }
        }
        return Math.abs(lr-fr+1)*Math.abs(lc-fc+1);
    }
}