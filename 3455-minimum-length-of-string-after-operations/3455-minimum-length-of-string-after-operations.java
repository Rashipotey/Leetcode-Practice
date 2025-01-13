class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        int len=0;
        if(n<3) return n;
        else{
            HashMap<Character, Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            for(Map.Entry<Character, Integer> entry:map.entrySet()){
                len+=(entry.getValue()%2==0)?2:1;
            }
        }
        return len;
    }
}