class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0, r=0;
        for(int n:nums){
            l=Math.max(n,l);
            r+=n;
        }
        int res=r;
        while(l<=r){
            int m=l+(r-l)/2;
            if(isFeasible(nums, m, k)){
                res=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return res;
    }
    private boolean isFeasible(int[] nums, int maxS, int k){
        int c=1;
        int currS=0;
        for(int n:nums){
            currS+=n;
            if(currS>maxS){
                c++;
                currS=n;
                if(c>k) return false;
            }
        }
        return true;
    }
}