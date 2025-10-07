class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        int ans[]=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<n;i++){
            if(rains[i]==0){
                set.add(i);
                ans[i]=1;
            }
            else{
                int lakeN=rains[i];
                ans[i]=-1;
                if(map.containsKey(lakeN)){
                    int lastRainDay=map.get(lakeN);
                    Integer dryDay=set.higher(lastRainDay);
                    if(dryDay==null) return new int[]{};
                    ans[dryDay]=lakeN;
                    set.remove(dryDay);
                }
                map.put(lakeN,i);
            }          
        }
        return ans;
    }
}