class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol=0, endCol=mat[0].length-1;
        while(startCol<=endCol){
            int maxR=0, midC=startCol+(endCol-startCol)/2;
            for(int i=0;i<mat.length;i++){
                maxR=mat[i][midC]>=mat[maxR][midC]?i:maxR;
            }
            boolean leftIsBig=midC-1>=startCol && mat[maxR][midC-1]>mat[maxR][midC];
            boolean rightIsBig=midC+1<=endCol && mat[maxR][midC+1]>mat[maxR][midC];
            if(!leftIsBig && !rightIsBig){
                return new int[]{maxR, midC};
            }else if(rightIsBig){
                startCol=midC+1;
            }else{
                endCol=midC-1;
            }
        }
        return null;
    }
}