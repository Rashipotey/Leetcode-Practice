class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack=new Stack<>();
        Stack<Integer> starStack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                openStack.push(i);
            }else if(ch=='*'){
                starStack.push(i);
            }else if(ch==')'){
                if(!openStack.isEmpty()){
                    openStack.pop();
                }else if(!starStack.empty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }
        }
        while(!openStack.empty() && !starStack.empty()){
            if(openStack.peek()> starStack.peek()){
                return false;
            }
            openStack.pop();
            starStack.pop();
        }
        return openStack.empty();
    }
}