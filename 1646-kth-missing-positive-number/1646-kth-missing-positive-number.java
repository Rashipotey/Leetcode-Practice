class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0, h=arr.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            int miss=arr[m]-(m+1); //missing numbers before arr[m]
            if(miss<k){
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return l+k;
    }
}