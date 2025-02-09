class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> li=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            Integer[] temp=new Integer[i+1];
            Arrays.fill(temp,1);
            li.add(Arrays.asList(temp));
        }
        for(int i=2;i<numRows;i++){
            for(int j=1;j<li.get(i).size()-1;j++){
                li.get(i).set(j,li.get(i-1).get(j-1)+li.get(i-1).get(j));
            }
        }
        return li;
    }
}