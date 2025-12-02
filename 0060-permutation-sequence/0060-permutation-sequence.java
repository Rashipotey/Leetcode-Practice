class Solution {
    public String getPermutation(int n, int k) {
        int res[]=new int[1];
        int kArr[]={k};
        backtrack(n,kArr,new ArrayList<>(),new boolean[n+1],res);
        return String.valueOf(res[0]);
    }
    private void backtrack(int n, int[] k, List<Integer> li, boolean[] used, int[] res){
        if(li.size()==n){
            k[0]--;
            if(k[0]==0){
                int num=0;
                for(int l:li){
                    num=num*10+l;
                }
                res[0]=num;
                return;
            }
        }
        for(int i=1;i<=n;i++){
            if(used[i]) continue;
            used[i]=true;
            li.add(i);
            backtrack(n,k,li,used,res);
            used[i]=false;
            li.remove(li.size()-1);
        }
    }
}