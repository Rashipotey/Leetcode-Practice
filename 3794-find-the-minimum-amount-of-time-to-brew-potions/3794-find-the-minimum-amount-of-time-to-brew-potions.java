class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n=skill.length, m=mana.length;
        long[] time=new long[n];
        time[0]=(long)skill[0]*mana[0];
        for(int i=1;i<n;i++){
            time[i]=time[i-1]+(long)skill[i]*mana[0];
        }
        for(int potionNo=1;potionNo<m;potionNo++){
            long startTime=binarySearch(time,skill,mana,potionNo);
            for(int i=0;i<n;i++){
                if(i==0) time[0]=startTime+(long)skill[i]*mana[potionNo];
                else time[i]=time[i-1]+(long)mana[potionNo]*skill[i];
            }
        }
        return time[n-1];
    }
    private long binarySearch(long[] prevTime, int[]skill, int[]mana, int potionNo){
        long l=prevTime[0], r=prevTime[prevTime.length-1];
        while(l<r){
            long m=l+(r-l)/2;
            if(canStart(m,potionNo,skill,mana,prevTime)){
                r=m;
            }else{
                l=m+1;
            }
        }
        return l;
    }
    private boolean canStart(long start, int potionNo, int[]skill, int[]mana, long[] prevTime){
        long currTime=start;
        for(int i=0;i<skill.length;i++){
            if(currTime<prevTime[i]) return false;
            currTime+=skill[i]*(long)mana[potionNo];
        }
        return true;
    }
}