class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer,int[]> map=new HashMap<>();
        int rows[]=new int[mat.length];
        int cols[]=new int[mat[0].length];
        Arrays.fill(rows,mat[0].length);
        Arrays.fill(cols,mat.length);
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        
        for(int i=0;i<arr.length;i++){
            int [] ind=map.get(arr[i]);
            if(--rows[ind[0]]==0 || --cols[ind[1]]==0){
                return i;
            }
        }
        return -1;
    }
}