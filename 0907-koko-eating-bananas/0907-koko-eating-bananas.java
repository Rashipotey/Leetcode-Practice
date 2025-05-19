class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=0;
        for(int pile:piles){
            r=Math.max(r,pile);
        }
        while(l<r){
            int m=l+(r-l)/2;
            int total=0;
            for(int pile:piles){
                total+=(pile+m-1)/m;
            }
            if(total<=h) r=m;
            else l=m+1;
        }
        return l;
    }
}