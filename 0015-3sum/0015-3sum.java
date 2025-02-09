class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> li=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int fixed=nums[i];
            Map<Integer, Integer> map=new HashMap<>();
            for(int j=i+1;j<nums.length;j++){
                if(map.containsKey(-(fixed+nums[j]))){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(fixed);
                    temp.add(nums[j]);
                    temp.add(-(nums[j]+fixed));
                    set.add(temp);
                }
                map.put(nums[j],j);
            }
        }
        li.addAll(set);
        return li;
    }
}