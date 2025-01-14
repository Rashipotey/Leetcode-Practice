class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int [] ans=new int[n];
        int eq=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<ans.length;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            map.put(B[i],map.getOrDefault(B[i],0)+1);
            if(A[i]!=B[i]){
                if(map.get(A[i])==2) eq++;
                if(map.get(B[i])==2) eq++;
            }else{
                eq++;
            }
            ans[i]=eq;
        }
        return ans;
    }
}