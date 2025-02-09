class Solution {
    public long countBadPairs(int[] nums) {
        long ans=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff=i-nums[i];
            int goodPairCount=map.getOrDefault(diff,0);
            ans+=i-goodPairCount;
            map.put(diff, goodPairCount+1);
        }
        return ans;
    }
}