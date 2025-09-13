class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len=nums.length+1;
        int i=0, sum=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            while(sum>=target){
                len=Math.min(len, j-i+1);
                sum-=nums[i];
                i++;
            }
        }
        return (len==nums.length+1)?0:len;
    }
}