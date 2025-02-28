class Solution {
    public int maxProduct(int[] nums) {
        int p1=nums[0], p2=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=Math.max(nums[i], Math.max(nums[i]*p1, nums[i]*p2));
            p2=Math.min(nums[i], Math.min(nums[i]*p1, nums[i]*p2));
            p1=temp;
            res=Math.max(res,p1);
        }
        return res;
    }
}