class Solution {
    public int minimumIndex(List<Integer> nums) {
        int x=nums.get(0), count=0, xCount=0, n=nums.size();
        for(int num:nums){
            if(num==x){
                count++;
            }else{
                count--;
            }
            if(count==0){
                x=num;
                count=1;
            }
        }
        for(int num:nums){
            if(num==x){
                xCount++;
            }
        }
        count=0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==x){
                count++;
            }
            int rem=xCount-count;
            if(count*2>i+1 && rem*2>n-i-1){
                return i;
            }
        }
        return -1;
    }
}