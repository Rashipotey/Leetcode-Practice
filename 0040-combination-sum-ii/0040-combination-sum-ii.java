class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates, target,res, path);
        return res;
    }
    public void backtrack(int c, int[] candidates, int target, List<List<Integer>> res, List<Integer> path){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=c;i<candidates.length;i++){
            if(i>c && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            path.add(candidates[i]);
            backtrack(i+1,candidates,target-candidates[i],res,path);
            path.remove(path.size()-1);
        }
    }
}