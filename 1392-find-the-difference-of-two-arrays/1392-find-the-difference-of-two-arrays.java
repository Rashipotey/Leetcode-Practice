class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            set.add(nums2[i]);
        }
        l.add(new ArrayList<>());
        for(int i=0;i<nums1.length;i++){
            if(!set.contains(nums1[i]) && !l.get(0).contains(nums1[i])){
                l.get(0).add(nums1[i]);
            }
        }
        for(int i=0;i<nums1.length;i++){
            set.remove(nums1[i]);
        }
        l.add(new ArrayList<>());
        for(int n:set){
            l.get(1).add(n);
        }
        return l;
    }
}