class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map=new HashMap<>();
        int i=0, j=0, maxL=0, maxF=0;
        while(j<s.length()){
            char c=s.charAt(j);
            map.put(c, map.getOrDefault(c,0)+1);
            maxF=Math.max(maxF,map.get(c));
            if((j-i+1)-maxF>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            maxL=Math.max(maxL,j-i+1);
            j++;
        }
        return maxL;
    }
}