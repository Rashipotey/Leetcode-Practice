class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length, m=heights[0].length;
        boolean[][] pac=new boolean[n][m];
        boolean[][] atl=new boolean[n][m];
        List<List<Integer>> res=new ArrayList<>();
        Queue<int[]> pacQ=new LinkedList<>();
        Queue<int[]> atlQ=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            pacQ.add(new int[]{i,0});
            atlQ.add(new int[]{i,m-1});
            pac[i][0]=true;
            atl[i][m-1]=true;
        }
        for(int i=0;i<m;i++){
            pacQ.add(new int[]{0,i});
            atlQ.add(new int[]{n-1,i});
            pac[0][i]=true;
            atl[n-1][i]=true;
        }
        bfs(pacQ,pac,heights);
        bfs(atlQ,atl,heights);
        for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(pac[i][j] && atl[i][j]) res.add(Arrays.asList(i,j));
                }
            }
            return res;
    }
    private void bfs(Queue<int[]> q, boolean[][] visit, int[][]heights){
        int n=heights.length, m=heights[0].length;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] p=q.poll();
            int r=p[0], c=p[1];
            for(int[] d:dir){
                int nr=d[0]+r, nc=d[1]+c;
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(!visit[nr][nc] && heights[r][c]<=heights[nr][nc]){
                        q.add(new int[]{nr, nc});
                        visit[nr][nc]=true;
                    }
                }
            }
        }
    }
}