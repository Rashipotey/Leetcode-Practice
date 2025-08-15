class Solution {
    public boolean isPowerOfFour(int n) {
        for(int i=0;i<=31;i+=2){
            if(1<<i==n) return true;
        }
        return false;
    }
}