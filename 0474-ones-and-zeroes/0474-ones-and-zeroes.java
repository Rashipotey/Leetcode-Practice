class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, Integer> dp=new HashMap<>();
        return helper(strs,m,n,0,dp);
    }
    private int helper(String[] strs, int m, int n, int i, Map<String, Integer> dp){
        if(i==strs.length) return 0;
        String key=m+","+n+","+i;
        if(dp.containsKey(key)) return dp.get(key);
        int z=0, o=0;
        for(char c:strs[i].toCharArray()){
            if(c=='0') z++;
            else o++;
        }
        int exc=helper(strs,m,n,i+1,dp);
        int inc=0;
        if(m>=z && n>=o){
            inc=1+helper(strs,m-z,n-o,i+1,dp);
        }
        dp.put(key,Math.max(exc,inc));
        return dp.get(key);
    }
}