class Solution {
    public int maximum69Number (int num) {
        int n=num, p=-1, i=0;
        while(num>0){
            int temp=num%10;
            if(temp==6){
                p=i;
            }
            num/=10;
            i++;
        }
        if(p!=-1){
            n+=3*(int)Math.pow(10,p);
        }
        return n;
    }
}