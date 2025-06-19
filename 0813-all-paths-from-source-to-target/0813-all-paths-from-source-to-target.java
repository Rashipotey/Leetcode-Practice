class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        int s=0, d=graph.length-1;
        dfs(graph,s,d,res,new ArrayList<>());
        return res;
    }
    private void dfs(int[][] graph, int s, int d, List<List<Integer>> res, List<Integer> p){
        p.add(s);
        if(s==d) res.add(new ArrayList<>(p));
        for(int n:graph[s]){
            dfs(graph,n,d,res,p);
            p.remove(p.size()-1);
        }
    }
}