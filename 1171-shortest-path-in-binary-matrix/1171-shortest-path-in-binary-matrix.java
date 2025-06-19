class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,1},{1,-1},{-1,-1}};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,1});
        boolean [][] visit=new boolean[n][n];
        visit[0][0]=true;
        while(!q.isEmpty()){
            int []curr=q.poll();
            int r=curr[0], c=curr[1], dist=curr[2];
            if(r==n-1 && c==n-1) return dist;
            for(int[] d: dir){
                int nr=d[0]+r, nc=d[1]+c;
                if(nr>=0 && nr<n && nc>=0 && nc<n){
                    if(grid[nr][nc]==0  && !visit[nr][nc]){
                        visit[nr][nc]=true;
                        q.add(new int[]{nr,nc,dist+1});
                    }
                }
            } 
        }
        return -1;
    }
}