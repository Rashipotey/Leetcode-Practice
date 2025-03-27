class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> m=new HashMap<>();
        Map<Integer, Integer> m1=new HashMap<>();
        int n=nums.size();
        for(int num:nums){
            m1.put(num,m1.getOrDefault(num,0)+1);
        }
        for(int i=0;i<n;i++){
            int num=nums.get(i);
            m.put(num,m.getOrDefault(num,0)+1);
            m1.put(num,m1.get(num)-1);
            if(m.get(num)*2>i+1 && m1.get(num)*2>n-i-1){
                return i;
            }
        }
        return -1;
    }
}