class Solution {
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board, word,0,i,j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int r, int c){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!=word.charAt(i)){
            return false;
        }
        if(i==word.length()-1){
            return true;
        }
        char temp=board[r][c];
        board[r][c]='#';
        for(int[] d:dir){
            int nx=r+d[0], ny=c+d[1];
            if(dfs(board,word,i+1,nx,ny)) return true;
        }
        board[r][c]=temp;  
        return false;
    }
}