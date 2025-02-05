class Solution {
    public int maxDepth(String s) {
        int depth=0, maxDepth=0;
		Stack<Character> st=new Stack<>();
		for(int i=0;i<s.length();i++){
		    char c=s.charAt(i);
		    if(c=='('){
		        st.push(c);
		        depth++;
		    }else if(c==')'){
		        st.pop();
		        depth--;
		    }
		    maxDepth=Math.max(maxDepth,depth);
		}
        return maxDepth;
    }
}