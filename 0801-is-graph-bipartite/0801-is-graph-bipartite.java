class Solution {
    public boolean isBipartite(int[][] graph) {
        //using the graph coloring algo- 
        //as nodes are to be partitioned into 2 sets, use 2 colors
        //-1 -not yet colored, 0-yellow, 1-blue
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!dfs(graph,color,i)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][]graph, int[] color, int curr){
        for(int i:graph[curr]){
            if(color[i]==-1){
                if(color[curr]==0) color[i]=1;
                else color[i]=0;
                if(!dfs(graph,color,i)) return false;
            }else if(color[i]==color[curr]){
                return false;
            }
        }
        return true;
    }
}