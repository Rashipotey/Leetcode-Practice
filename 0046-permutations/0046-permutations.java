class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(nums,new boolean[nums.length],new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> l, List<List<Integer>> res){
        if(l.size()==nums.length){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(used[j]) continue;
            used[j]=true;
            l.add(nums[j]);
            backtrack(nums,used,l,res);
            l.remove(l.size()-1);
            used[j]=false;
        }
    }
}