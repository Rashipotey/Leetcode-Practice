class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max=Double.MIN_VALUE;
        int maxA=Integer.MIN_VALUE;
        for(int[] d:dimensions){
            int l=d[0], w=d[1];
            double diag=Math.sqrt((l*l)+(w*w));
            int area=l*w;
            if(max<diag){
                max=diag;
                maxA=area;

            }else if(diag==max){
                maxA=Math.max(maxA,area);
            }
        }
        return maxA;
    }
}