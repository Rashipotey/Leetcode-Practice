class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Integer> st=new Stack<>();
        st.push(num.charAt(0)-'0');
        for(int i=1;i<num.length();i++){
            while(!st.empty() && (num.charAt(i)-'0')<st.peek() && k>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i)-'0');
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.empty()){
            char c=(char) ('0'+st.pop());
            sb.append(c);
        }
        while(sb.length()>1 && sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}