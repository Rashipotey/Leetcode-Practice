class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,new boolean[nums.length],new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            curr.add(nums[i]);
            used[i]=true;
            backtrack(nums,used,curr,res);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }
}