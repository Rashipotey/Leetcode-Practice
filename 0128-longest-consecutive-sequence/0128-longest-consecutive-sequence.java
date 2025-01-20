class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max=1;
        int c=0;
        for(Integer it:set){
            if(!set.contains(it-1)){
                c=1;
                int curr=it;
                while(set.contains(curr+1)){
                    c++;
                    curr++;
                }
                max=Math.max(max,c);
            }
        }
        return max;
    }
}