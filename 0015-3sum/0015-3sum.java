class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> li=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>0) break;
            int l=i+1, r=n-1;
            while(l<r){
                if(nums[l]+nums[r]==-nums[i]){
                    li.add(new ArrayList<>());
                    li.get(li.size()-1).add(nums[l]);
                    li.get(li.size()-1).add(nums[r]);
                    li.get(li.size()-1).add(nums[i]);
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }else if(nums[l]+nums[r]>-nums[i]) r--;
                else l++;
            }
        }
        return li;
    }
}