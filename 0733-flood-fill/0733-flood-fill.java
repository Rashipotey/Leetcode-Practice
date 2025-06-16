class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalC=image[sr][sc];
        if(originalC==color) return image;

        Queue<int[]> q=new LinkedList<>();
        int n=image.length, m=image[0].length;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        q.add(new int[]{sr,sc});

        while(!q.isEmpty()){
            int[] curr=q.poll();
            image[curr[0]][curr[1]]=color;
            for(int[] d:dir){
                int nx=d[0]+curr[0], ny=d[1]+curr[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && image[nx][ny]==originalC){
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return image;
    }
}