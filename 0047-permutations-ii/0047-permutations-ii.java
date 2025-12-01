class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        backtrack(nums,new boolean[nums.length],new ArrayList<>(),set);
        return new ArrayList<>(set);
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> curr, Set<List<Integer>> set){
        if(curr.size()==nums.length){
            set.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            curr.add(nums[i]);
            used[i]=true;
            backtrack(nums,used,curr,set);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }
}