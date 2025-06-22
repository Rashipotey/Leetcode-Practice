class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        for(int i=0;i<n;i++){
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
            pq.add(new int[]{i,0});
            dist[i][i]=0;
            while(!pq.isEmpty()){
                int[]curr=pq.poll();
                int u=curr[0], d=curr[1];
                if(d>dist[i][u]) continue;
                for(int[] neigh:adj.get(u)){
                    int v=neigh[0], w=neigh[1];
                    if(dist[i][v]>d+w && d+w<=distanceThreshold){
                        dist[i][v]=d+w;
                        pq.add(new int[]{v,dist[i][v]});
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        int city=-1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=min){
                min=count;
                city=i;
            }
        }
        return city;
    }
}