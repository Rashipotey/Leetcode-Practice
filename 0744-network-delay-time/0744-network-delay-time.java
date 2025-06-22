class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        int [] time=new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k]=0;
        while(!pq.isEmpty()){
            int []curr=pq.poll();
            int u=curr[0];
            for(int[] neigh:adj.get(u)){
                int v=neigh[0], w=neigh[1];  
                if(time[v]>w+time[u]){
                    time[v]=time[u]+w;
                    pq.add(new int[]{v,time[v]});
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(time[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,time[i]);
        }
        return max;
    }
}