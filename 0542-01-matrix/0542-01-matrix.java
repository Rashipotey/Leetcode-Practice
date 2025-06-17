class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q=new LinkedList<>();
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0) q.add(new int[]{i,j});
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0], y=curr[1];
            for(int [] d:dir){
                int nx=d[0]+x, ny=d[1]+y;
                if(nx>=0 && nx<mat.length && ny>=0 && ny<mat[0].length){
                    if(mat[nx][ny]>mat[x][y]+1){
                        mat[nx][ny]=mat[x][y]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return mat;
    }
}