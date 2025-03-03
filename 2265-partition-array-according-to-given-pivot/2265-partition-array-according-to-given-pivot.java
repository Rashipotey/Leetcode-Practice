class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[]=new int[nums.length];
        int p=0, q=nums.length-1;
        for(int i=0, j=nums.length-1;i<nums.length;i++, j--){
            if(nums[i]<pivot){
                ans[p++]=nums[i];
            }
            if(nums[j]>pivot){
                ans[q--]=nums[j];
            }
        }
        while(p<=q){
            ans[p++]=pivot;
        }
        return ans;
    }
}