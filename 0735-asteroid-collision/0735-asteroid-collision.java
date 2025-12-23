class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;
        for(int a:asteroids){
            if(a>0){
                st.push(a);
            }else{
                while(!st.empty() && st.peek()>0 && st.peek()<-a){
                    st.pop();
                }
                if(st.empty() || st.peek()<0){
                    st.push(a);
                }
                if(st.peek()==-a){
                    st.pop();
                }
            }
        }
        int [] res=new int[st.size()];
        int i=st.size()-1;
        while(!st.empty()){
            res[i--]=st.pop();
        }
        return res;
    }
}