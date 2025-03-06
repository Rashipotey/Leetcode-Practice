class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int miss=0, rep=0, n=grid.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                map.put(grid[i][j], map.getOrDefault(grid[i][j],0)+1);
            }
        }
        for(int i=1;i<=n*n;i++){
            if(!map.containsKey(i)) miss=i;  
            else if(map.get(i)==2) rep=i; 
        }
        return new int[]{rep,miss};
    }
}