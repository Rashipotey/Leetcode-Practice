class MinStack {
    Stack<Integer> s;
    int min=Integer.MAX_VALUE;
    public MinStack() {
        s=new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(min>val){
            min=val;
        }
    }
    
    public void pop() {
        int t=s.pop();
        if(t==min){
            Stack<Integer> st=new Stack<>();
            min=Integer.MAX_VALUE;
            while(!s.empty()){
                t=s.pop();
                st.push(t);
                if(min>t){
                    min=t;
                }
            }
            while(!st.empty()){
                s.push(st.pop());
            }
        }
    }
    
    public int top() {
        if(s.empty()){
            return -1;
        }
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */