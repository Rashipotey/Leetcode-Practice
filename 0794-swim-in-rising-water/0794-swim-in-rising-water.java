class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<int[]> q=new PriorityQueue<>((a, b)->a[0]-b[0]);
        q.add(new int[]{grid[0][0],0,0});
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        boolean visit[][]=new boolean[n][n];
        visit[0][0]=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int time=curr[0], r=curr[1], c=curr[2];
            if(r==n-1 && c==n-1) return time;
            for(int [] d:dir){
                int nr=r+d[0], nc=c+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n){
                    if(!visit[nr][nc]){
                        visit[nr][nc]=true;
                        q.add(new int[]{Math.max(time,grid[nr][nc]),nr,nc});
                    }
                }
            }
        }
        return -1;
    }
}