class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        int[] parent=new int[n];
        int rank[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }        
        for(int[] edge:connections){
            int x=find(parent, edge[0]);
            int y=find(parent, edge[1]);
            if(x!=y) union(parent, rank, x, y); 
        }
        for(int i=0;i<n;i++){
            if(parent[i]==i) count++;
        }
        return count-1;
    }
    private int find(int[] parent, int i){
        if(parent[i]==i) return i;
        return find(parent, parent[i]);
    }
    private void union(int[]parent, int[]rank, int x, int y){
        if(rank[x]<rank[y]){
            parent[x]=y;
        }else if(rank[y]<rank[x]){
            parent[y]=x;
        }else{
            parent[y]=x;
            rank[x]++;
        }
    }
}