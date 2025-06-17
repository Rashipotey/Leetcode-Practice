class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][board[0].length-1]=='O') dfs(board,i,board[0].length-1);
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O') dfs(board,0,i);
            if(board[board.length-1][i]=='O') dfs(board,board.length-1,i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=(board[i][j]=='O')?'X':board[i][j];
                board[i][j]=(board[i][j]=='E')?'O':board[i][j];
            }
        }
    }
    private void dfs(char[][] board, int i, int j){
        board[i][j]='E';
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] d:dir){
            int x=d[0]+i, y=d[1]+j;
            if(x>=0 && x<board.length && y>=0 && y<board[0].length){
                if(board[x][y]=='O') dfs(board,x,y);
            }
        }
    }
}