class Solution {
    public int longestSubarray(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        } 
        int l=0, curr=0;
        for(int n:nums){
            if(n==max){
                curr++;
                l=Math.max(l,curr);
            }else{
                curr=0;
            }
        }
        return l;
    }
}