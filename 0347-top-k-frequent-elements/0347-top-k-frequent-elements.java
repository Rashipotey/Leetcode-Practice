class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll(); 
            }
        }
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll().getKey();
        }
        return res;
    }
}