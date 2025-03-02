class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> l=new ArrayList<>();
        if(nums.length==0) return l;
        int prev=nums[0],start=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-prev==1){
                prev=nums[i];
            }else{
                if(start==prev){
                    l.add(String.valueOf(start));
                }else{
                    l.add(String.valueOf(start)+"->"+String.valueOf(prev));
                }
                start=nums[i];
                prev=nums[i];
            }
        }
        if(start==prev){
            l.add(String.valueOf(start));
        }else{
            l.add(String.valueOf(start)+"->"+String.valueOf(prev));
        }
        return l;
    }
}
