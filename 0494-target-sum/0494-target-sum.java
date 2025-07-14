class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int res=helper(nums, target, 0, 0);
        return res;
    }
    private int helper(int[] nums, int target, int i, int sum){
        if(i==nums.length) {
            if(sum==target) return 1;
            else return 0;
        }
        int count1=helper(nums,target,i+1,sum+nums[i]);
        int count2=helper(nums,target,i+1,sum-nums[i]);
        return count1+count2;
    }
}