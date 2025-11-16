class Solution {
    final static int mod=1000000007;
    public int numSub(String s) {
        long count=0, curr=0;
        int n=s.length();
        for(int j=0;j<n;j++){
            if(s.charAt(j)=='0'){
                curr=0;
            }else{
                curr++;
                count=(count+curr)%mod;
            }
        }
        return (int)count;
    }
}