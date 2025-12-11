class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int time[]=new int[1];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> edge:connections){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        int disc[]=new int[n];
        int low[]=new int[n];
        Arrays.fill(disc,-1);
        Arrays.fill(low,-1);
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,disc,low,graph,bridges,time);
        return bridges;
    }
    private void dfs(int u, int par, int[] disc, int[] low, List<List<Integer>> graph, List<List<Integer>> bridges, int[] time){
        disc[u]=low[u]=time[0]++;
        for(int v:graph.get(u)){
            if(v==par) continue;
            if(disc[v]==-1){
                dfs(v,u,disc,low,graph,bridges,time);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>disc[u]) bridges.add(Arrays.asList(u,v));
            }else{
                low[u]=Math.min(low[u],disc[v]);
            }
        }
    }
}