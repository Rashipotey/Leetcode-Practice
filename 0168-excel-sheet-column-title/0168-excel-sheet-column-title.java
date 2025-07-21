class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        int ch=0;
        while(columnNumber>0){
            columnNumber--; 
            ch='A'+(columnNumber%26);
            sb.append((char)ch);
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }
}