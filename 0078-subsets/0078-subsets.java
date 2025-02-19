class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        recursion(nums, res, 0, new ArrayList<>());
        return res;
    }
    public void recursion(int [] nums, List<List<Integer>> res, int ind,List<Integer> curr){
        res.add(new ArrayList<>(curr));
        for(int i=ind; i<nums.length;i++){
            curr.add(nums[i]);
            recursion(nums, res, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}