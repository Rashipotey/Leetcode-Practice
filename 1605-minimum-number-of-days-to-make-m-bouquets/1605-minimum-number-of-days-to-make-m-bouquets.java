class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(m*k>n) return -1;
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min, bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int l=min, h=max;
        int res=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(canMake(bloomDay,mid,m,k)){
                res=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
    public boolean canMake(int[] bloomDay, int day, int m, int k){
        int count=0, res=0; //count->no. of flowers, res->no.of bouquets
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count++;
                if(count==k){
                    res++;
                    count=0;
                }
            }else{
                count=0;
            }
        }
        return res>=m;
    }
}