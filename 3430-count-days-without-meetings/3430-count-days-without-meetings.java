class Solution {
    public int countDays(int days, int[][] meetings) {
        int free=0, end=0;
        Arrays.sort(meetings,Comparator.comparingInt(a->a[0]));
        for(int[] meeting:meetings){
            int s=meeting[0], e=meeting[1];
            if(s>end+1){
                free+=s-end-1;
            }
            end=Math.max(end,e);
        }
        free+=days-end;
        return free;
    }
}