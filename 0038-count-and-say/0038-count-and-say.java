class Solution {
    public String createNextSeq(String s){
        StringBuilder str=new StringBuilder();
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                str.append(count).append(s.charAt(i-1));
                count=1;
            }
        }
        str.append(count).append(s.charAt(s.length()-1));
        return str.toString();
    }
    public String countAndSay(int n) {
        String s="1";
        for(int i=1;i<n;i++){
            s=createNextSeq(s);
        }
        return s;
    }
}