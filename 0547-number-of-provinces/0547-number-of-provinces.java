class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean [] visit=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(isConnected,visit,i,new ArrayList<>());
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected, boolean[] visit, int curr, List<Integer> comp){
        visit[curr]=true;
        comp.add(curr);
        for(int i=0;i<visit.length;i++){
            if(isConnected[curr][i]==1 && !visit[i]){
                dfs(isConnected,visit,i,comp);
            }
        }
    }
}