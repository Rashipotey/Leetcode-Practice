class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length;
        int last=nums2[m-1];
        long res=0, lastC=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            res+=(Math.abs(nums1[i]-nums2[i]));
            if((nums1[i]<=last && last<=nums2[i]) || (nums2[i]<=last && last<=nums1[i])) lastC=0;
            else{
                lastC=Math.min(lastC, Math.min(Math.abs(nums1[i]-last), Math.abs(nums2[i]-last)));
            }
        }
        res+=lastC+1;
        return res;
    }
}