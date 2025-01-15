class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1] && nums[i]!=nums[i-1]){
                return nums[i];
            }
        }
        if(nums.length!=1 && nums[0]!=nums[1]) return nums[0];
        else return nums[nums.length-1];
    }
}