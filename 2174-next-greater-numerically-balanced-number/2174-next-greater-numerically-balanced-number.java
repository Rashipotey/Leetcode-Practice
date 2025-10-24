class Solution {
    public int nextBeautifulNumber(int n) {
        int num=n+1;
        while(true){
            if(isBeautiful(num)) return num;
            num++;
        }
    }
    private boolean isBeautiful(int n){
        int[] count=new int[10];
        int num=n;
        while(num>0){
            count[num%10]++;
            num/=10;
        }
        for(int i=0;i<=9;i++){
            if(count[i]>0 && count[i]!=i) return false;
        }
        return true;
    }
}