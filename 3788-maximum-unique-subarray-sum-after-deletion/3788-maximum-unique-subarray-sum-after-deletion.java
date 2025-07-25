class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int sum=0, max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) set.add(nums[i]);
            if(nums[i]>max) max=nums[i];
        }
        if(set.isEmpty()){
            return max;
        }
        for(int n:set){
            sum+=n;
        }
        return sum;
    }
}