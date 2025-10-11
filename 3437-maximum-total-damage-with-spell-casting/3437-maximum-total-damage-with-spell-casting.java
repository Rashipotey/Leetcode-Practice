class Solution {
    public long maximumTotalDamage(int[] power) {
        int n=power.length;
        Arrays.sort(power);
        List<Integer> uqPow=new ArrayList<>();
        List<Long> totalD=new ArrayList<>();

        for(int i=0;i<n;i++){
            int currPow=power[i];
            long sum=currPow;
            while(i+1<n && power[i+1]==currPow){
                i++;
                sum+=currPow;
            }
            uqPow.add(currPow);
            totalD.add(sum);
        }
        long[]dp=new long[uqPow.size()+1];
        for(int j=uqPow.size()-1;j>=0;j--){
            long skip=dp[j+1];
            long take=totalD.get(j);
            int nextI=j+1;
            while(nextI<uqPow.size() && uqPow.get(nextI)-uqPow.get(j)<=2){
                nextI++;
            }
            take+=dp[nextI];
            dp[j]=Math.max(skip,take);
        }
        return dp[0];
    }
}