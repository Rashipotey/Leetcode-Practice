class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int x1=0, x2=0;
        int n=nums1.length, m=nums2.length;
        if(n%2!=0){
            for(int m1:nums2){
                x1^=m1;
            }
        }
        if(m%2!=0){
            for(int n1:nums1){
                x2^=n1;
            }
        }
        return x1^x2;
    }
}