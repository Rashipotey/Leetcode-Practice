class Solution {
    public int count=0; 
    public boolean isSafe(char[][] board, int row, int col){
        for(int i=row;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public void nQueens(char[][] board, int row ){
        if(row == board.length){
            count++;
            return;
        }
        for(int i=0; i < board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q'; 
                nQueens(board, row+1);
                board[row][i] = '.'; 
            }
        }

    }
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(char [] row: board){
            Arrays.fill(row, '.');
        }
        nQueens(board, 0);
        return count;
    }
}