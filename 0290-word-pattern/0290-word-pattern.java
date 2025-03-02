class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1=new HashMap<>();
        Map<String, Character> map2=new HashMap<>();
        String[] arr=s.split(" ");
        if (arr.length!=pattern.length()) {
            return false;
        }
        for(int i=0;i<arr.length;i++){
            char c=pattern.charAt(i);
            String word=arr[i];
            if(map1.containsKey(c)){
                if(!map1.get(c).equals(word)){
                    return false;
                }
            }else{
                map1.put(c, word);
            }
            if(map2.containsKey(word)){
                if(map2.get(word)!=c){
                    return false;
                }
            }else{
                map2.put(word, c);
            }
        }
        return true;
    }
}
