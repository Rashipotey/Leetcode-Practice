class Solution {
    public int slidingWindow(int[] nums, int goal){
        int i=0, count=0;
        int sum=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            while(i<=j && sum>goal){
                sum-=nums[i++];
            }
            count+=j-i+1;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindow(nums, goal)-slidingWindow(nums, goal-1);
    }
}