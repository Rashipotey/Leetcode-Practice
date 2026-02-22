class Solution {
    public int trap(int[] height) {
         int l[]=new int[height.length];
        int r[]=new int[height.length];
        
        int maxLeft=height[0];
        for(int i=0;i<height.length;i++){
            maxLeft=Math.max(maxLeft, height[i]);
            l[i]=maxLeft;
        }
        
        int maxRight=height[height.length-1];
        r[height.length-1]=height[height.length-1];
        for (int i=height.length-1;i>=0;i--) {
            maxRight=Math.max(maxRight, height[i]);
            r[i]=maxRight;
        }
        
        int sum=0;
        for(int i=0;i<height.length;i++){
            if(Math.min(l[i],r[i])-height[i]>0){
                sum+=Math.min(l[i],r[i])-height[i];
            }
        }
        return sum;
    }
}