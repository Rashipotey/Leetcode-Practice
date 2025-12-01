class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat=new int[n][n];
        int num=1;
        int row=0, rowEnd=n-1, col=0, colEnd=n-1;
        while(row<=rowEnd && col<=colEnd){
            for(int i=col;i<=colEnd;i++){
                mat[row][i]=num++;
            }
            row++;
            for(int i=row;i<=rowEnd;i++){
                mat[i][colEnd]=num++;
            }
            colEnd--;
            if(row<=rowEnd){
                for(int i=colEnd;i>=col;i--){
                    mat[rowEnd][i]=num++;
                }
            }
            rowEnd--;
            if(col<=colEnd){
                for(int i=rowEnd;i>=row;i--){
                    mat[i][col]=num++;
                }
            }
            col++;
        }
        return mat;
    }
}