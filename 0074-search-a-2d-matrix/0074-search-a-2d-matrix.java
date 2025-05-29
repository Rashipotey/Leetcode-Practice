class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length, m=matrix[0].length;
        int l=0, h=n*m-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int val=matrix[mid/m][mid%m];
            if(target<val){
                h=mid-1;
            }else if(target>val){
                l=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}