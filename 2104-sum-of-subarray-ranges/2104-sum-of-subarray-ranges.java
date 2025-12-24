class Solution {
    public long subArrayRanges(int[] nums) {
        long sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                max=Math.max(max,nums[j]);
                min=Math.min(min,nums[j]);
                sum+=(max-min);
            }
        }
        return sum;
    }
}