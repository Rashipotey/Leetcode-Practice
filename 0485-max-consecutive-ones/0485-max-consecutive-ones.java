class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0, lastMax=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                max++;
            }else{
                max=0;
            }
            if(lastMax<max){
                lastMax=max;
            }
        }
        return lastMax;   
    }
}