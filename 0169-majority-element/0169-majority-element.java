class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length, key=0;
        Arrays.sort(nums);
        int c=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                c++;
            }else{
                if(c>n/2){
                    return nums[i];
                }else{
                    c=1;
                }
            }
        }
        return nums[n-1];
    }
}