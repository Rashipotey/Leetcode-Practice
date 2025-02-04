class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=nums[0], res=nums[0];
        List<Integer> al=new ArrayList<>();
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                max=Math.max(nums[i],nums[i]+max);
                res=Math.max(res,max);
            }else{
                al.add(res);
                max=nums[i];
                res=nums[i];
            }
        }
        al.add(res);
        max=res;
        if(al.size()>0){
            max=al.get(0);
            for(Integer i:al){
                max=Math.max(i,max);
            }
        }
        return max;
    }
}