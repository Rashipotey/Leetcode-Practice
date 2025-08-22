class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char arr[]=new char[26];
            for(char c:strs[i].toCharArray()){
                arr[c-'a']++;
            }
            String newS=String.valueOf(arr);
            if(!map.containsKey(newS)){
                map.put(newS,new ArrayList<>());
            }
            map.get(newS).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}