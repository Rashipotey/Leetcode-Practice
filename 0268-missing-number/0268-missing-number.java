class Solution {
    public int missingNumber(int[] nums) {
        int xorA=0, max=0;
        for(int i=0;i<nums.length;i++){
            xorA^=nums[i];
            if(max<nums[i]) max=nums[i];
        }
        int xorF=0;
        for(int i=0;i<=nums.length;i++){
            xorF^=i;
        }
        return xorA^xorF;
    }
}