class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recursion(nums, target, 0, 0);
    }
    private int recursion(int[] nums, int target, int i, int sum){
        if(i==nums.length) return sum==target?1:0;
        int add=recursion(nums, target, i+1, sum+nums[i]);
        int sub=recursion(nums, target, i+1, sum-nums[i]);
        return add+sub;
    }
}