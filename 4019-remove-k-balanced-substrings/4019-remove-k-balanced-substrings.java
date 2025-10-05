class Solution {
    public String removeSubstring(String s, int k) {
        String temp=s;
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(char c:temp.toCharArray()){
            sb.append(c);
            if(c=='(') count++;
            else{
                if(count>=k && sb.length()>=2*k){
                    int len=sb.length();
                    boolean canRem=true;
                    for(int i=len-2*k;i<len-k;i++){
                        if(sb.charAt(i)!='('){
                            canRem=false; 
                            break;
                        }
                    }
                    for(int i=len-k;i<len;i++){
                        if(sb.charAt(i)!=')'){
                            canRem=false; 
                            break;
                        }
                    }
                    if(canRem){
                        sb.delete(sb.length()-2*k,sb.length());
                        count-=k;
                    }
                }
            }
        }
        return sb.toString();
    }
}