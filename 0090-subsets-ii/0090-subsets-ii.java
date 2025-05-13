class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
    }
    public void backtrack(int c, int [] nums, List<Integer> path, List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        for(int i=c;i<nums.length;i++){
            if(i>c && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(i+1,nums,path,res);
            path.remove(path.size()-1);
        }
    }
}