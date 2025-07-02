class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k)-atMostK(nums,k-1);
    }
    private int atMostK(int[] nums, int k){
        int i=0, count=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int j=0;j<nums.length;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if (map.get(nums[j])==1){
                k--;
            }
            while(k<0){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) {
                    map.remove(nums[i]);
                    k++;
                }
                i++;
            }
            count+=j-i+1;
        }
        return count;
    }
}