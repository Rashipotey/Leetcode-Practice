class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, long target, int start, int k){
        List<List<Integer>> res=new ArrayList<>();
        if(start==nums.length){
            return res;
        }
        long ave_value=target/k;
        if(nums[start]>ave_value|| ave_value>nums[nums.length-1]){
            return res;
        }
        if(k==2){
            return twoSum(nums, target, start);
        }
        for(int i=start;i<nums.length;i++){
            if(i==start||nums[i-1]!=nums[i]){
                for(List<Integer> subset:kSum(nums,target-nums[i],i+1,k-1)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size()-1).addAll(subset);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, long target, int start){
        List<List<Integer>> res=new ArrayList<>();
        int l=start,r=nums.length-1;
        while(l<r){
            int curr=nums[l]+nums[r];
            if(curr<target||(l>start && nums[l]==nums[l-1])){
                ++l;
            }else if(curr>target||(r<nums.length-1 && nums[r]==nums[r+1])){
                --r;
            }else{
                res.add(Arrays.asList(nums[l++], nums[r--]));
            }
        }
        return res;
    }
}