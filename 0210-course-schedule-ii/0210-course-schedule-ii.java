class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            g.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean visit[]=new boolean[numCourses];
        boolean pathVisit[]=new boolean[numCourses];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!visit[i]){
                if(topoSortUtil(g,visit,pathVisit,s,i)){
                    return new int[0];
                }
            }
        }
        int[] res=new int[numCourses];
        for(int i=0;i<res.length;i++){
            res[i]=s.pop();
        }
        return res;
    }
    private boolean topoSortUtil(List<List<Integer>> g,boolean visit[],boolean pathVisit[],Stack<Integer> s,int curr){
        visit[curr]=true;
        pathVisit[curr]=true;
        for(Integer i:g.get(curr)){
            if(!visit[i]){
                if(topoSortUtil(g,visit,pathVisit,s,i)) return true;
            }else if(pathVisit[i]) return true;
        }
        s.push(curr);
        pathVisit[curr]=false;
        return false;
    }
}