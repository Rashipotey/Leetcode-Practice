class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int n=sb.length();
            if(n>=2 && sb.charAt(n-1)==s.charAt(i) && sb.charAt(n-2)==s.charAt(i)){
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}