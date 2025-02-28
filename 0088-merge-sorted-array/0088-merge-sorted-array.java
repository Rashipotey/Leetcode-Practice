class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=n+m;
        int gap=(len/2)+(len%2);
        while(gap>0){
            int left=0;
            int right=left+gap;
            while (right<len) {
                if(left<m && right>=m){
                    swapIfGreater(nums1, nums2, left, right-m);
                }
                else if(left>=m){
                    swapIfGreater(nums2, nums2, left-m, right-m);
                }
                else{
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++; right++;
            }
            if(gap==1) break;
            gap=(gap/2)+(gap%2);
        }
        for(int i=m, j=0;i<nums1.length && j<nums2.length;i++, j++){
            nums1[i]=nums2[j];
        }
    }
    public static void swapIfGreater(int[] nums1, int[] nums2, int ind1, int ind2) {
        if(nums1[ind1]>nums2[ind2]){
            int temp=nums1[ind1];
            nums1[ind1]=nums2[ind2];
            nums2[ind2]=temp;
        }
    }
}