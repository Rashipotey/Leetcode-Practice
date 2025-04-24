class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return slidingWindow(nums,k)-slidingWindow(nums, k-1);
    }
    public int slidingWindow(int nums[], int k){
        int i=0, odd=0, count=0;
        for(int j=0;j<nums.length;j++){
            if((nums[j]&1)!=0) odd++;
            while(i<=j && odd>k){
                if((nums[i]&1)!=0) odd--;
                i++;
            }
            count+=j-i+1;
        }
        return count;
    }
}