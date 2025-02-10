class Solution {
    public String clearDigits(String s) {
        StringBuilder str=new StringBuilder();
        if(!Character.isDigit(s.charAt(0))){
            str.append(s.charAt(0));
        }
        for(int i=1;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                if(str.length()>0 && !Character.isDigit(str.charAt(str.length() - 1))){
                    str.deleteCharAt(str.length()-1);
                }
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}