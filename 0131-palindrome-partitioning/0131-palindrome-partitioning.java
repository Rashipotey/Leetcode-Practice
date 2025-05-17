class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        recursion(s, 0, new ArrayList<>(), res);
        return res;
    }
    public void recursion(String s, int c, List<String> path, List<List<String>> res){
        if(c==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=c;i<s.length();i++){
            String prefix=s.substring(c,i+1);
            if(isPalindrome(prefix)){
                path.add(prefix);
                recursion(s, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    boolean isPalindrome(String s){
        int i=0, n=s.length()-1;
        while(i<n){
            if(s.charAt(i++)!=s.charAt(n--)){
                return false;
            }
        }
        return true;
    }
}