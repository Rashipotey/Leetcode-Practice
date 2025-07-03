class Solution {
    public char kthCharacter(int k) {
        StringBuilder s=new StringBuilder("a");
        while(s.length()<k){
            int n=s.length();
            for(int i=0;i<n;i++){
                char curr=s.charAt(i);
                char next=(char) ('a'+(curr-'a'+1)%26);
                s.append(next);
            }
        }
        return s.toString().charAt(k-1);
    }
}