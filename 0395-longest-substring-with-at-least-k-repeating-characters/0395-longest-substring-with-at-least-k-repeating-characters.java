class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s,0,s.length(),k);
    }
    private int helper(String s, int i, int j, int k){
        if(j-i<k) return 0;
        int[] freq=new int[26];
        for(int l=i;l<j;l++){
            freq[s.charAt(l)-'a']++;
        }
        for(int m=i;m<j;m++){
            if(freq[s.charAt(m)-'a']<k){
                int mid=m+1;
                while(mid<j && freq[s.charAt(mid)-'a']<k){
                    mid++;
                }
                return Math.max(helper(s,i,m,k), helper(s,mid,j,k));
            }
        }
        return j-i;
    }
}