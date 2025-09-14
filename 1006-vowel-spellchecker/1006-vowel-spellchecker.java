class Solution {
    Set<String> words;
    Map<String, String> cap, vow;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        words=new HashSet<>();
        cap=new HashMap<>();
        vow=new HashMap<>();
        for(String w:wordlist){
            words.add(w);
            String lowWord=w.toLowerCase();
            cap.putIfAbsent(lowWord,w);
            String lowWordVow=vowel(lowWord);
            vow.putIfAbsent(lowWordVow,w);
        }
        String[] ans=new String[queries.length];
        int t=0;
        for(String q:queries){
            ans[t++]=solve(q);
        }
        return ans;
    }
    private String solve(String query){
        if(words.contains(query)) return query;
        String queryL=query.toLowerCase();
        if(cap.containsKey(queryL)) return cap.get(queryL);
        String queryV=vowel(queryL);
        if(vow.containsKey(queryV)) return vow.get(queryV);
        return "";
    }
    private String vowel(String s){
        StringBuilder ans=new StringBuilder();
        for(char c:s.toCharArray()){
            ans.append(isVowel(c)?'*':c);
        }
        return ans.toString();
    }
    private boolean isVowel(char c){
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }
}