class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> prev=new HashSet<>();
        for(int j=0;j<arr.length;j++){
            Set<Integer> curr=new HashSet<>();
            curr.add(arr[j]);
            for(int p:prev){
                curr.add(p|arr[j]);
            }
            prev=curr;
            set.addAll(curr);
        }
        return set.size();
    }
}