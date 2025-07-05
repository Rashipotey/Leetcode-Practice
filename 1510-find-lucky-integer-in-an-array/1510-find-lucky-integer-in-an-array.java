class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map=new HashMap<>();
        int max=-1;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            if(e.getKey()==e.getValue()) max=Math.max(max, e.getValue());
        }
        return max;
    }
}