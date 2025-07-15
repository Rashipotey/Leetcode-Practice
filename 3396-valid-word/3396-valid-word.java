class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        String regex="^(?=[a-zA-Z0-9]{3,}$)(?=.*[aeiouAEIOU])(?=.*[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z])[a-zA-Z0-9]+$";
        return word.matches(regex);
    }
}