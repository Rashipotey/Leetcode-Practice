class Solution {
    public String sortVowels(String s) {
        int[] count=new int[1000];
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                count[c-'A']++;
            }
        }
        String sortedVowel="AEIOUaeiou";
        StringBuilder res=new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++){
            if(!isVowel(s.charAt(i))){
                res.append(s.charAt(i));
            }else{
                while(count[sortedVowel.charAt(j)-'A']==0){
                    j++;
                }
                res.append(sortedVowel.charAt(j));
                count[sortedVowel.charAt(j)-'A']--;
            }
        }
        return res.toString();
    }
    private boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
            return true;
        }
        return false;
    }
}