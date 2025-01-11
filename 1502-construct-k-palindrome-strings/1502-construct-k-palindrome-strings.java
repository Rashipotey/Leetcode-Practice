class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()==k) return true;
        if(s.length()<k) return false;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int countEvens=0, countOdds=0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()%2==0){
                countEvens++;
            }else{
                countOdds++;
            }
        }
        return countOdds<=k;
    }
}