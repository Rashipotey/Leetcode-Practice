class Solution {
    public long subArrayRanges(int[] nums) {
        // sum of (max-min)== (sum of max values of all subarrays)-(sum of min values of all subarrays)
        int n=nums.length;
        long ans=0;
        Deque<Integer> st=new ArrayDeque<>();
        //finding each element is the min element of how many subarrays
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || nums[st.peekLast()]>=nums[i])){
                int m=st.pollLast();
                int l=st.isEmpty()?-1:st.peekLast();
                ans-=(long)nums[m]*(i-m)*(m-l);
            }
            st.add(i);
        }
        st.clear();
        //finding each element is the max of how many subarrays
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || nums[st.peekLast()]<=nums[i])){
                int m=st.pollLast();
                int l=st.isEmpty()?-1:st.peekLast();
                ans+=(long)nums[m]*(i-m)*(m-l);
            }
            st.add(i);
        }
        return ans;
    }
}