class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> st=new ArrayDeque<>();
        int ans[]=new int[nums1.length];
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:nums2){
            while(!st.isEmpty() && i>st.peekLast()){
                map.put(st.pollLast(),i);
            }
            st.addLast(i);
        }
        int i=0;
        for(int n:nums1){
            ans[i++]=map.getOrDefault(n,-1);
        }
        return ans;
    }
}