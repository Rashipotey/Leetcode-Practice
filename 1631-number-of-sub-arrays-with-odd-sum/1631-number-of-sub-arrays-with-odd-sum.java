class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD=1000000007;
        int sum=0;
        int oddCount=0, evenCount=1, count=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if((sum%2)==1){
                count+=evenCount;
                oddCount++;
            }else{
                count+=oddCount;
                evenCount++;
            }
            count%=MOD;
        }
        return count;
    }
}