class Solution {
    public int nthUglyNumber(int n) {
        int ugly[]=new int[n];
        ugly[0]=1;
        int i2=0, i3=0, i5=0;
        for(int i=1;i<n;i++){
            int n2=ugly[i2]*2;
            int n3=ugly[i3]*3;
            int n5=ugly[i5]*5;
            ugly[i]=Math.min(n2,Math.min(n3,n5));
            if(ugly[i]==n2) i2++;
            if(ugly[i]==n3) i3++;
            if(ugly[i]==n5) i5++;
        }
        return ugly[n-1];
    }
}