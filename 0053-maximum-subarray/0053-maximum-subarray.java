class Solution {
    public int maxSubArray(int[] nums) {
        int maxS=Integer.MIN_VALUE;
        int currS=0;
        for(int i=0;i<nums.length;i++){
            currS+=nums[i];
            if(currS>maxS) maxS=currS;
            if(currS<0) currS=0;
        }
        return maxS;
    }
}