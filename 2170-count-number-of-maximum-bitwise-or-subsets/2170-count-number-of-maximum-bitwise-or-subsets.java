class Solution {
    int max=0, count=0;
    public int countMaxOrSubsets(int[] nums) {
       for(int n:nums){
        max|=n;
       }
       backtrack(nums,0,0);
       return count;
    }
    private void backtrack(int[]nums, int i, int curr){
        if(i==nums.length){
            if(curr==max) count++;
            return;
        }
        backtrack(nums, i+1, curr|nums[i]);
        backtrack(nums, i+1, curr);
    }
}