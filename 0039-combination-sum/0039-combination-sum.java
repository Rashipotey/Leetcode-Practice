class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp=new ArrayList<>();
        for(int i=0;i<=target;i++){
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(new ArrayList<>());
        for(int candidate:candidates){
            for(int sum=candidate;sum<=target;sum++){
                for(List<Integer>combination:dp.get(sum-candidate)){
                    List<Integer> newCombo=new ArrayList<>(combination);
                    newCombo.add(candidate);
                    dp.get(sum).add(newCombo);
                }
            }
        }
        return dp.get(target);
    }
}