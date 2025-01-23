class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> s=new HashSet<>(map.values());
        if(map.size()>s.size()) return false;
        return true;
    }
}