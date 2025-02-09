class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> al=new ArrayList<>();
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>nums.length/3 && !al.contains(nums[i])){
                al.add(nums[i]);
            }
        }
        return al;
    }
}