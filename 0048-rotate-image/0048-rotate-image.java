class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int i=0, j=0;
        //transpose
        while(i<matrix.length && j<matrix[0].length){
            swap(matrix,i,j);
            j++;
            if(j==matrix[0].length){
                i++;
                j=i;
            }
        }
        //swapping columns
        int col=0, colEnd=matrix[0].length-1;
        while(col<colEnd){
            swapCol(matrix,col, colEnd);
            col++; colEnd--;
        }
    }
    public void swap(int [][] matrix, int i, int j){
        int t=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=t;
    }
    public void swapCol(int[][]matrix, int col, int colEnd){
        for(int i=0;i<matrix.length;i++){
            int t=matrix[i][col];
            matrix[i][col]=matrix[i][colEnd];
            matrix[i][colEnd]=t;
        }
    }
}