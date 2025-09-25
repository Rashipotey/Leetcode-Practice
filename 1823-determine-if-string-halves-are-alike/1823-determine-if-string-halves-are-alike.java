class Solution {
    public boolean halvesAreAlike(String s) {
        int mid=s.length()/2, vowa=0, vowb=0;
        for(int i=0;i<mid;i++){
            if(isVowel(s.charAt(i))) vowa++;
        }
        for(int i=mid;i<s.length();i++){
            if(isVowel(s.charAt(i))) vowb++;
        }
        return vowa==vowb;
    }
    private boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}