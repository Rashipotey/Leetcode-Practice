class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res=new ArrayList<>();
        res.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(!areAnagrams(words[i],words[i-1])){
                res.add(words[i]);
            }
        }
        return res;
    }
    private boolean areAnagrams(String word1, String word2){
        if(word1.length()!=word2.length()) return false;
        int[] freq=new int[26];
        for(int i=0;i<word1.length();i++){
            freq[word1.charAt(i)-'a']++;
            freq[word2.charAt(i)-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
}