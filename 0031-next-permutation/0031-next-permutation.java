class Solution {
    public void nextPermutation(int[] nums) {
        int ind1=-1, ind2=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind1=i;
                break;
            }
        }
        if(ind1==-1){
            reverse(nums,0);
        }else{
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[ind1]){
                    ind2=i;
                    break;
                }
            }
            swap(nums,ind1,ind2);
            reverse(nums,ind1+1);
        }
    }
    void swap(int[]nums, int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    void reverse(int[] nums, int s){
        int i=s;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}