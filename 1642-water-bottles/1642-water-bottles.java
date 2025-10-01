class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res=0, rem=0;
        while(numBottles>0){
            res+=numBottles;
            int empty=numBottles+rem;
            numBottles=empty/numExchange;
            rem=empty%numExchange;
        }
        return res;
    }
}