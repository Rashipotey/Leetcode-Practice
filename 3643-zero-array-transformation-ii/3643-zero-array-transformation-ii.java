class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length, sum=0, k=0;
        int[] diff=new int[n+1];
        for(int i=0;i<n;i++){
            while(sum+diff[i]<nums[i]){
                k++;
                if(k>queries.length){
                    return -1;
                }
                int l=queries[k-1][0], r=queries[k-1][1], val=queries[k-1][2];
                if(r>=i){
                    diff[Math.max(l,i)]+=val;
                    diff[r+1]-=val;
                }
            }
            sum+=diff[i];
        }
        return k;
    }
}