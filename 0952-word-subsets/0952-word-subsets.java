class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> al=new ArrayList<>();
        Map<Character, Integer> map=new HashMap<>();
        for(String word:words2){
            HashMap<Character, Integer> map1=new HashMap<>();
            for(char c: word.toCharArray()){
                map1.put(c,map1.getOrDefault(c,0)+1);
            }
            for(Map.Entry<Character, Integer> entry:map1.entrySet()){
                map.put(entry.getKey(), Math.max(map.getOrDefault(entry.getKey(),0),entry.getValue()));
            }
        }
        for(String word: words1){
            Map<Character, Integer> map1=new HashMap<>();
            for(char c:word.toCharArray()) {
                map1.put(c,map1.getOrDefault(c,0)+1);
            }
            boolean isUniversal=true;
            for (Map.Entry<Character, Integer> entry:map.entrySet()) {
                char c=entry.getKey();
                int count=entry.getValue();
                if (map1.getOrDefault(c,0)<count) {
                    isUniversal=false;
                    break;
                }
            }
            if(isUniversal) {
                al.add(word);
            }
        }
        return al;
    }
}