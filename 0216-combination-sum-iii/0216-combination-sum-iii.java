class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(1,n,k,new ArrayList<>(), res);
        return res;
    }
    public void backtrack(int c, int n, int k, List<Integer> path, List<List<Integer>> res){
        if(path.size()==k && n==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=c;i<=9;i++){
            if(i>n) break;
            path.add(i);
            backtrack(i+1, n-i, k, path, res);
            path.remove(path.size()-1);
        }
    }
}