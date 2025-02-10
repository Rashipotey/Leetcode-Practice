class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res=new int[2];
        res[0]=-1;
        res[1]=-1;
        if(nums.length==0) return res;
        int left=binarySearch(nums, target, true);
        if(left==-1) return res;
        int right=binarySearch(nums, target, false);
        res[0]=left;
        res[1]=right;
        return res;
    }
    int binarySearch(int [] nums, int target, boolean find){
        int l=0, r=nums.length-1, res=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                res=m;
                if(find){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }else if(nums[m]<target){
                l=m+1;
            } 
            else{
                r=m-1;
            }
        }
        return res;
    }
}