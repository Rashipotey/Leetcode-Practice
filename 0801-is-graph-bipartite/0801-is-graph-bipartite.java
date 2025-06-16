class Solution {
    public boolean isBipartite(int[][] graph) {
        //using the graph coloring algo- 
        //as nodes are to be partitioned into 2 sets, use 2 colors
        //-1 -not yet colored, 0-yellow, 1-blue
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                q.add(i);
                color[i]=0;
                while(!q.isEmpty()){
                    int curr=q.poll();
                    for(int n:graph[curr]){
                        if(color[n]==-1){
                            if(color[curr]==0) color[n]=1;
                            else color[n]=0;
                            q.add(n);
                        }else if(color[curr]==color[n]) return false;
                    }
                }
            }
        }
        return true;
    }
}