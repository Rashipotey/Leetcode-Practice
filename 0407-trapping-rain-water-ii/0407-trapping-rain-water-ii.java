class Solution {
    static class Cell implements Comparable<Cell>{
        int height, i, j;
        Cell(int height, int i, int j){
            this.height=height;
            this.i=i;
            this.j=j;
        }
        public int compareTo(Cell other) {
            return this.height-other.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int n=heightMap.length, m=heightMap[0].length;
        if(n<=2 || m<=2) return 0;
        boolean graph[][]=new boolean[n][m];
        PriorityQueue<Cell> boundary=new PriorityQueue<>();
        int totalWater=0;
        for(int i=0;i<n;i++){
            boundary.add(new Cell(heightMap[i][0], i, 0));
            graph[i][0]=true;
            boundary.add(new Cell(heightMap[i][m-1], i, m-1));
            graph[i][m-1]=true;
        }
        for(int i=0;i<m;i++){
            boundary.add(new Cell(heightMap[0][i],0,i));
            graph[0][i]=true;
            boundary.add(new Cell(heightMap[n-1][i],n-1,i));
            graph[n-1][i]=true;
        }
        while(!boundary.isEmpty()){
            Cell curr=boundary.poll();
            int ht=curr.height, i=curr.i, j=curr.j;
            for(int[] d:dir){
                int nr=i+d[0], nc=j+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !graph[nr][nc]){
                    if(heightMap[nr][nc]<ht){
                        totalWater+=(ht-heightMap[nr][nc]);
                    }
                    boundary.add(new Cell(Math.max(heightMap[nr][nc], ht), nr, nc));
                    graph[nr][nc]=true;
                }
            }
        }
        return totalWater;
    }
}