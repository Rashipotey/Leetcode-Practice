class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n=skill.length, m=mana.length;
        long[] time=new long[n];
        for(int j=0;j<m;j++){
            long currTime=0;
            for(int i=0;i<n;i++){
                currTime=Math.max(currTime,time[i])+(long)skill[i]*mana[j];
            }
            time[n-1]=currTime;
            for(int i=n-2;i>=0;i--){
                time[i]=time[i+1]-(long)skill[i+1]*mana[j];
            }
        }
        return time[n-1];
    }
}