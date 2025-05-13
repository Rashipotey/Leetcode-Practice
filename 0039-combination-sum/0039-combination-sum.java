class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,target,candidates,new ArrayList<>(),res);
        return res;
    }
    public void backtrack(int c, int target, int [] candidates, List<Integer> path, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=c;i<candidates.length;i++){
            if(candidates[i]>target) break;
            path.add(candidates[i]);
            backtrack(i,target-candidates[i],candidates,path,res);
            path.remove(path.size()-1);
        }
    }
}