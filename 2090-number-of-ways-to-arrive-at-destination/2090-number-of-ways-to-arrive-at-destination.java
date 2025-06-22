class Solution {
    int mod=1000000007;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new int[]{roads[i][1],roads[i][2]});
            adj.get(roads[i][1]).add(new int[]{roads[i][0],roads[i][2]});
        }
        long dist[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        int ways[]=new int[n];
        Arrays.fill(ways,0);
        ways[0]=1;
        int count=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[1]));
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long []curr=pq.poll();
            int u=(int)curr[0];
            long d=curr[1];
            if(d>dist[u]) continue;
            for(int[] neigh:adj.get(u)){
                int v=neigh[0], w=neigh[1];
                if(dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                    ways[v]=ways[u];
                    pq.add(new long[]{v, dist[v]});
                }else if(dist[v]==dist[u]+w){
                    ways[v]=(ways[v]+ways[u])%mod;
                }
            }
        }
        return ways[n-1];
    }
}