class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length, m=matrix[0].length;
        int l=0, h=matrix[0].length-1;
        while(l<=n-1 && h>=0){
            if(target==matrix[l][h]) return true;
            else if(target<matrix[l][h]) h--;
            else l++;
        }
        return false;
    }
}