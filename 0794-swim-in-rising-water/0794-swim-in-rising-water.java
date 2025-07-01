class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int [][] visited=new int[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        visited[0][0]=1;
        int maxEle=0;
        int dir[][]={{0,-1},{0,1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int ele=curr[0], x=curr[1], y=curr[2];
            maxEle=Math.max(maxEle,ele);
            if(x==n-1 && y==n-1) return maxEle;
            for(int[] d:dir){
                int nx=d[0]+x, ny=d[1]+y;
                if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny]==0){
                    visited[nx][ny]=1;
                    pq.add(new int[]{grid[nx][ny],nx,ny});
                }
            }
        }
        return -1;
    }
}