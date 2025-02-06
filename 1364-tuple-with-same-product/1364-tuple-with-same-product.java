class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        for(int i:map.keySet()){
            int t=map.get(i);
            int m=((t-1)*t)/2;
            ans+=8*m;
        }
        return ans;
    }
}