class Solution {
    public int maximumSum(int[] nums) {
        PriorityQueue<Integer>[] digitSums=new PriorityQueue[82];
        for(int i=0;i<82;i++){
            digitSums[i]=new PriorityQueue<Integer>();
        }
        int max=-1;
        for(int num:nums){
            int sum=digitSum(num);
            digitSums[sum].add(num);
            if(digitSums[sum].size()>2){
                digitSums[sum].poll();
            }
        }
        for(PriorityQueue<Integer> minHeap:digitSums){
            if(minHeap.size()==2){
                int first=minHeap.poll();
                int sec=minHeap.poll();
                max=Math.max(max, first+sec);
            }
        }
        return max;
    }
    int digitSum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}