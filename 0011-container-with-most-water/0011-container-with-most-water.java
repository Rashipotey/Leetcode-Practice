class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0, right=n-1;
        int max=0;
        while(left<right){
            int curr=Math.min(height[left], height[right])*(right-left);
            max=Math.max(max,curr);
            if(height[left]<height[right]) left++;
            else right--;
        }
        return max;
    }
}