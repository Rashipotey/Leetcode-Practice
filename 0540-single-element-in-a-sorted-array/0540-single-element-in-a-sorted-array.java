class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0, r=nums.length-2;
        if(nums.length==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[nums.length-2]!=nums[nums.length-1]){
            return nums[nums.length-1];
        }
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]!=nums[m-1] && nums[m]!=nums[m+1]){
                return nums[m];
            }
            if((m%2==1 && nums[m]==nums[m-1]) || (m%2==0 && nums[m]==nums[m+1])){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return -1;
    }
}