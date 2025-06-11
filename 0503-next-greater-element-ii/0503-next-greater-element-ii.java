class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int [] ans=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
           int curr=nums[i%n];
           while(!st.empty() && st.peek()<=curr){
            st.pop();
           }
           if(i<n){
            ans[i]=st.empty()?-1:st.peek();
           }
           st.push(curr);
        }
        return ans;
    }
}