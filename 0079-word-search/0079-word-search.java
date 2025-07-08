class Solution {
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board, word,0,i,j)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int r, int c){
        if(board[r][c]!=word.charAt(i)) return false;
        if(i==word.length()-1) return true;
        char temp=board[r][c];
        board[r][c]='#';
        for(int d[]:dir){
            int nx=d[0]+r, ny=d[1]+c;
            if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length){
                if(dfs(board,word,i+1,nx,ny)) return true;
            }
        }
        board[r][c]=temp;
        return false;
    }
}