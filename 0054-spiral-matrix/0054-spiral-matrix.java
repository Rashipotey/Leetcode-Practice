class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> al=new ArrayList<>();
        int row=0, col=0, rowEnd=matrix.length-1, colEnd=matrix[0].length-1;
        while(row<=rowEnd && col<=colEnd){
            for(int i=col;i<=colEnd;i++){
                al.add(matrix[row][i]);
            }
            row++;
            for(int i=row;i<=rowEnd;i++){
                al.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(row<=rowEnd){
                for(int i=colEnd;i>=col;i--){
                    al.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(col<=colEnd){
                for(int i=rowEnd;i>=row;i--){
                    al.add(matrix[i][col]);
                }
            }
            col++;
        }
        return al;
    }
}