class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }
        List<List<Integer>> comp=getComponents(g, n);
        int count=0;
        for(List<Integer> al:comp){
            int size=al.size();
            int degreeSum=0;
            for(Integer i:al){
                degreeSum+=g.get(i).size();
            }
            if(degreeSum==size*(size-1)){
                count++;
            }
        }
        return count;
    }
    private List<List<Integer>> getComponents(List<List<Integer>> g, int n){
        boolean visit[]=new boolean[n];
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visit[i]) {
                List<Integer> curr=new ArrayList<>();
                dfs(g,visit,i,curr);
                res.add(curr);
            }
        }
        return res;
    }
    private void dfs(List<List<Integer>> g, boolean visit[], int curr, List<Integer> comp){
        visit[curr]=true;
        comp.add(curr);
        for(Integer i:g.get(curr)){
            if(!visit[i]) dfs(g,visit,i,comp);
        }
    }
}