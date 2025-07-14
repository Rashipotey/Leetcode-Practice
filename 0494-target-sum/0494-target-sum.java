class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       Map<String, Integer> dp=new HashMap<>();
       int res=helper(nums, target, 0, 0, dp);
        return res;
    }
    private int helper(int[] nums, int target, int i, int sum, Map<String, Integer> dp){
        String key=i+","+sum;
        if(dp.containsKey(key)) return dp.get(key);
        if(i==nums.length) {
            return sum==target?1:0;
        }
        int count1=helper(nums,target,i+1,sum+nums[i],dp);
        int count2=helper(nums,target,i+1,sum-nums[i],dp);
        dp.put(key,count1+count2);
        return dp.get(key);
    }
}