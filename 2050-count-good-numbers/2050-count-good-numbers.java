class Solution {
    final long mod=1000000007;
    public int countGoodNumbers(long n) {
        long odd=n/2;
        long even=(n+1)/2;
        return (int)((pow(5,even)*pow(4,odd))%mod);
    }
    public long pow(long x, long n){
        if(n==0) return 1;
        long half=pow(x,n/2);
        if(n%2==0) return (half*half)%mod;
        else return (half*half*x)%mod;
    }
}