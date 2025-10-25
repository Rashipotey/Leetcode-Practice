class Solution {
    public int totalMoney(int n) {
        int res=0, st=1;
        while(n>0){
            for(int i=0;i<Math.min(n,7);i++){
                res+=st+i;
            }
            st++;
            n-=7;
        }
        return res;
    }
}