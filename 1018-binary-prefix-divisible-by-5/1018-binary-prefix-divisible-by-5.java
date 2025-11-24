class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res=new ArrayList<>();
        int n=0;
        for(int i=0;i<nums.length;i++){
            n=(n*2+nums[i])%5;
            res.add(n==0);
        }
        return res;
    }
}