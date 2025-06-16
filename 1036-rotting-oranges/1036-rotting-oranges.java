class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                else if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int min=0;
        int dir[][]=new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; //up,down,left,right
        while(!q.isEmpty()){
            boolean hasNewRotten=false;
            int s=q.size();
            for(int i=0;i<s;i++){
                int [] curr=q.poll();
                for(int[] d:dir){
                    int nx=curr[0]+d[0], ny=curr[1]+d[1];
                    if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        fresh--;
                        q.add(new int[]{nx,ny});
                        hasNewRotten=true;
                    }
                }
            }
            if(hasNewRotten) min++;
        }
        return fresh==0?min:-1;
    }
}