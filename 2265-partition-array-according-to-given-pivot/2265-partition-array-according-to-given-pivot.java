class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                l1.add(nums[i]);
            }else if(nums[i]>pivot){
                l2.add(nums[i]);
            }else{
                count++;
            }
        }
        int k=0;
        for(int i=0;i<l1.size();i++){
            nums[k++]=l1.get(i);
        }
        for(int i=1;i<=count;i++){
            nums[k++]=pivot;
        }
        for(int i=0;i<l2.size();i++){
            nums[k++]=l2.get(i);
        }
        return nums;
    }
}