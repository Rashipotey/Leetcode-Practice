class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adj=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int[] indegree=new int[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int g:graph[i]){
                adj.get(g).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int neigh:adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}