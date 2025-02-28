class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    public int mergeSort(int[] nums, int l, int r){
        int count=0;
        if(l<r){
            int m=l+(r-l)/2;
            count+=mergeSort(nums,l,m);
            count+=mergeSort(nums,m+1,r);
            count+=countReversePairs(nums,l,m,r);
            merge(nums,l,m,r);
        }
        return count;
    }
    public int countReversePairs(int[] nums, int l, int m, int r){
        int count=0;
        int h=m+1;
        for(int i=l;i<=m;i++){
            while(h<=r && (long)nums[i]>(long)2*nums[h]) h++;
            count+=h-(m+1);
        }
        return count;
    }
    public void merge(int[] nums, int l, int m, int r){
        int []temp=new int[r-l+1];
        int i=l, j=m+1, k=0;
        while(i<=m && j<=r){
            if(nums[i]<nums[j]){
                temp[k]=nums[i++];
            }else{
                temp[k]=nums[j++];
            }
            k++;
        }
        while(i<=m){
            temp[k++]=nums[i++];
        }
        while(j<=r){
            temp[k++]=nums[j++];
        }
        for(int p=l, q=0;q<temp.length;p++,q++){
            nums[p]=temp[q];
        }
    }
}