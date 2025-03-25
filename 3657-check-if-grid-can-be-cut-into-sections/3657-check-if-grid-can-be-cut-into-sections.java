class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return checkCuts(rectangles,0)||checkCuts(rectangles,1);
    }
    public boolean checkCuts(int[][] rectangles, int dim){
        int gapCount=0;
        Arrays.sort(rectangles,(a,b)->Integer.compare(a[dim],b[dim]));
        int furthestEnd=rectangles[0][dim+2];
        for(int i=1;i<rectangles.length;i++){
            int[] rect=rectangles[i];
            if(furthestEnd<=rect[dim]){
                gapCount++;
            }
            furthestEnd=Math.max(furthestEnd, rect[dim+2]);
        }
        return gapCount>=2;
    }
}