class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        boolean isVowel=false, isCons=false;
        for(char c:word.toCharArray()){
            if(Character.isLetter(c)){
                char ch=Character.toLowerCase(c);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    isVowel=true;
                }else isCons=true;
            }else if(!Character.isDigit(c)) return false;
        }
        return isVowel && isCons;
    }
}