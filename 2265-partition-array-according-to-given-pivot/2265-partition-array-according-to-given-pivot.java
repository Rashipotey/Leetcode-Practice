class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[]=new int[nums.length];
        int numLess=0, numEqual=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot) numLess++;
            else if(nums[i]==pivot) numEqual++;
        }
        int i=0, j=numLess, k=numEqual+numLess;
        for(int p=0;p<nums.length;p++){
            int num=nums[p];
            if(num<pivot){
                ans[i++]=num;
            }else if(num>pivot){
                ans[k++]=num;
            }else{
                ans[j++]=pivot;
            }
        }
        return ans;
    }
}