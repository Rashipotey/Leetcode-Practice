class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res=0, empty=0;
        while(numBottles>0 || numExchange<=empty){
            if(numBottles>0){
                res+=numBottles;
                empty+=numBottles;
                numBottles=0;
            }else{
                numBottles++;
                empty-=numExchange;
                numExchange++;
            }
        }
        return res;
    }
}