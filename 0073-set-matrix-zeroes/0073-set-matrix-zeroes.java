class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        Set<int[]> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    set.add(new int[]{i,j});
                }
            }
        }
        for(int [] a:set){
            int r=a[0];
            int c=a[1];
            for(int i=0;i<n;i++){
                matrix[i][c]=0;
            }
            for(int i=0;i<m;i++){
                matrix[r][i]=0;
            }
        }
    }
}