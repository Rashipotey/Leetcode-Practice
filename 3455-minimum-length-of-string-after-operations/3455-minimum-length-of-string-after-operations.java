class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        if(n<3) return n;
        else{
            HashMap<Character, Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            for(Map.Entry<Character, Integer> entry:map.entrySet()){
                while(entry.getValue()>=3){
                    map.put(entry.getKey(),entry.getValue()-2);
                    n-=2;
                }
            }
        }
        return n;
    }
}