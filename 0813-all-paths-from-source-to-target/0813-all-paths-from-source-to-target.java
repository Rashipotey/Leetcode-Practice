class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        int s=0, d=graph.length-1;
        Queue<List<Integer>> q=new LinkedList<>();
        List<Integer> p=new ArrayList<>();
        q.add(p);
        p.add(s);
        while(!q.isEmpty()){
            List<Integer> currPath=q.poll();
            int last=currPath.get(currPath.size()-1);
            if(last==d) res.add(new ArrayList<>(currPath));
            for(int n:graph[last]){
                List<Integer> newP=new ArrayList<>(currPath);
                newP.add(n);
                q.add(newP);
            }
        }
        return res;
    }
}