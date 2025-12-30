class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Deque<Character> st=new ArrayDeque<>();
        for(char c:num.toCharArray()){
            while(!st.isEmpty() && c<st.peekLast() && k>0){
                st.pollLast();
                k--;
            }
            st.addLast(c);
        }
        while(k>0){
            st.pollLast();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            char c=st.pollLast();
            sb.append(c);
        }
        while(sb.length()>1 && sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}