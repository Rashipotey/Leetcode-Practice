class Solution {
    public int change(int amount, int[] coins) {
        Map<String,Integer> dp=new HashMap<>();
        return helper(amount,coins,0,0,dp);
    }
    private int helper(int amount, int[] coins, int i, int sum, Map<String, Integer> dp){
        if(sum==amount) return 1;
        if(sum>amount || i==coins.length) return 0;
        String s=i+","+sum;
        if(dp.containsKey(s)) return dp.get(s);
        int ways1=helper(amount,coins,i,sum+coins[i],dp);
        int ways2=helper(amount,coins,i+1,sum,dp);
        dp.put(s,ways1+ways2);
        return dp.get(s);
    }
}