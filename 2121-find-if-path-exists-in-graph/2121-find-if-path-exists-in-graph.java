class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visit[]=new boolean[n];
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int[]e:edges){
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        return dfs(g,visit,source,destination);
    }
    private boolean dfs(List<List<Integer>> g, boolean visit[], int source, int destination){
        if(source==destination) return true;
        visit[source]=true;
        for(int n:g.get(source)){
            if(!visit[n]){
                if(dfs(g,visit,n,destination)) return true;
            }
        }
        return false;
    }
}