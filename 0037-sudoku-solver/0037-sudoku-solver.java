class Solution {
     boolean[][] r = new boolean[9][10];
        boolean[][] c = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
    public void solveSudoku(char[][] board) {
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    c[j][board[i][j] - '0'] = true;
                    r[i][board[i][j] - '0'] = true;
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    box[boxIndex][board[i][j]-'0'] = true;
                }
            }
        }
        solve(board);
    }

    boolean solve(char[][] board) {   
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    for(int a=1; a<10; a++){
                        if(!r[i][a] && !c[j][a] && !box[boxIndex][a]){
                            r[i][a]=true;
                            c[j][a]=true;
                            box[boxIndex][a]=true;
                            board[i][j]=(char)(a+'0');
                            if(solve(board)) return true;

                            //backtrack
                            r[i][a]=false;
                            c[j][a]=false;
                            box[boxIndex][a]=false;
                            board[i][j]='.';

                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }
}