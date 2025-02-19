class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(n,0,0,"",res);
        return res;
    }
    public void backtrack(int n, int openC, int closeC, String curr, List<String> res){
        if(openC==n && closeC==n){
            res.add(curr);
            return;
        }
        if(openC<n){
            backtrack(n, openC+1, closeC, curr+'(', res);
        }
        if(closeC<openC){
            backtrack(n, openC, closeC+1, curr+')', res);
        }
    }
}