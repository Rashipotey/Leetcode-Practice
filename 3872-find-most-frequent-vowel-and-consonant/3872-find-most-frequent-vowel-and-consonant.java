class Solution {
    public int maxFreqSum(String s) {
        int [] count=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        int vow=0, cons=0;
        for(int i=0;i<count.length;i++){
            char c=(char) ('a'+i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                vow=Math.max(vow, count[i]);
            }else{
                cons=Math.max(cons,count[i]);
            }
        }
        return vow+cons;
    }
}