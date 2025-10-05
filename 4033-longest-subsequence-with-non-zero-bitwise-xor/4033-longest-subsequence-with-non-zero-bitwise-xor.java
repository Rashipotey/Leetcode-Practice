class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean allZero=true;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
            if(nums[i]!=0) allZero=false;
        }
        if(allZero) return 0;
        if(xor==0) return nums.length-1;
        else return nums.length;
    }
}