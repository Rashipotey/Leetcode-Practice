class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            res[i]=binarySearch(spells[i],potions,success);
        }
        return res;
    }
    private int binarySearch(int x, int[]potions, long s){
        int n=potions.length;
        int l=0, r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if((long)x*potions[m]>=s) r=m-1;
            else l=m+1;
        }
        return n-l;
    }
}