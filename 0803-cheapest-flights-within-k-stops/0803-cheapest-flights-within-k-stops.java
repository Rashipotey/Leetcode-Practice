class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[]=new int[n];
        int l=k+2;
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0,0});
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int u=curr[0];
            int d=curr[1];
            int stops=curr[2];
            if(stops>k) continue;
            for(int[] neigh:adj.get(u)){
                int v=neigh[0];
                int w=neigh[1];
                int newC=d+w;
                if(dist[v]>newC){
                    dist[v]=newC;
                    q.add(new int[]{v,dist[v],stops+1});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}