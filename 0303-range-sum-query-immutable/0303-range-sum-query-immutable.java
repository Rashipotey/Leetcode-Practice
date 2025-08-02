class NumArray {
    int [] nums;
    int pSum[];
    public NumArray(int[] nums) {
        this.nums=nums;
        pSum=new int[this.nums.length];
        pSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pSum[i]=pSum[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return pSum[right];
        else return pSum[right]-pSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */