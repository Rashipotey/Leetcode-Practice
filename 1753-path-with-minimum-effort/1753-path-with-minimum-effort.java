class Solution {
    public int minimumEffortPath(int[][] heights) {
        int diff[][]=new int[heights.length][heights[0].length];
        for(int []s:diff) Arrays.fill(s,Integer.MAX_VALUE);
        diff[0][0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int effort=curr[0];
            int x=curr[1], y=curr[2];
            if(x==heights.length-1 && y==heights[0].length-1) return effort;
            for(int[] d: dir){
                int nx=x+d[0], ny=y+d[1];
                if(nx>=0 && nx<heights.length && ny>=0 && ny<heights[0].length){
                    int nextE=Math.max(effort, Math.abs(heights[x][y]-heights[nx][ny]));
                    if(nextE<diff[nx][ny]){
                        diff[nx][ny]=nextE;
                        pq.offer(new int[]{nextE,nx,ny});
                    }
                }
            }
        }
        return 0;
    }
}