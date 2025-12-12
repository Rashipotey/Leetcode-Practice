class Solution {
    final static int MOD=1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int left[]=new int[n];
        int right[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.peek()]>arr[i]) st.pop();
            left[i]=st.empty()?i+1:i-st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()]>=arr[i]) st.pop();
            right[i]=st.empty()?n-i:st.peek()-i;
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            ans=(ans+(long)arr[i]*left[i]*right[i])%MOD;
        }
        return (int)ans;
    }
}