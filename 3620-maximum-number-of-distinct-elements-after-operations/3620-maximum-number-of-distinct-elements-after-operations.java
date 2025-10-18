class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int count=1;
        Arrays.sort(nums);
        nums[0]=nums[0]-k;
        for(int i=1;i<nums.length;i++){
            nums[i]=Math.min(Math.max(nums[i]-k,nums[i-1]+1),nums[i]+k);
            if(nums[i]>nums[i-1]) count++;
        }
        return count;
    }
}