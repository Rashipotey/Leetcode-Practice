class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        //instad of finding  if two subsets with sum=t exist, we only find if a subset with sum=t exists, because if total sum of subset is even then if there exists a subset with sum=t, there will also exist another subset with sum=t automatically.
        //we define a dp array indicating if sum=i exists or not
        int t=sum/2;
        boolean dp[]=new boolean[t+1];
        dp[0]=true;
        for(int n:nums){
            for(int i=t;i>=n;i--){
                dp[i]=dp[i] || dp[i-n]; //if a sum of i-n exists then we can just add n to get sum=i
            }
        }
        return dp[t];
    }
}