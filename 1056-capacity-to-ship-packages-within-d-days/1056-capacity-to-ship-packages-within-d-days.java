class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,h=0;
        for(int weight:weights){
            l=Math.max(l,weight);
            h+=weight;
        }
        int res=h;
        while(l<=h){
            int m=l+(h-l)/2;
            if(isPossible(weights,days,m)){
                res=m;
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return res;
    }
    private boolean isPossible(int [] weights, int days, int m){
        int sum=0, res=1;
        for(int i=0;i<weights.length;i++){
            if(sum+weights[i]>m){ 
                res++; 
                sum=0;
            }
            sum+=weights[i];
        }
        return res<=days;
    }
}