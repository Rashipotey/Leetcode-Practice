class Solution {
    public boolean doesAliceWin(String s) {
        int n=0;
        for(char c:s.toCharArray()){
            if(isVowel(c)) n++;
        }
        if(n==0) return false;
        else return true;
    }
    private boolean isVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
}