class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0, count=0;
        for(int n:nums){
            sum+=n;
            int mod=((sum%k)+k)%k;
            count+=map.getOrDefault(mod,0);
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
        return count;
    }
}