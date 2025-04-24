class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        int j=0, res=0;
        Set<Integer> set=new HashSet<>();
        Map<Integer, Integer> map=new HashMap<>();
        for(int i: nums){
            set.add(i);
        }
        int distinct=set.size();
        for(int i=0;i<n;i++){
            if(i>0){
                int r=nums[i-1];
                map.put(r,map.get(r)-1);
                if(map.get(r)==0){
                    map.remove(r);
                }
            }
            while(j<n && map.size()<distinct){
                int a=nums[j];
                map.put(a,map.getOrDefault(a,0)+1);
                j++;
            }
            if(map.size()==distinct){
                res+=n-j+1;
            }
        }
        return res;
    }
}