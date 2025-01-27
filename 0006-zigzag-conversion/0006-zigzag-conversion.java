class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length()<=numRows) return s;
        StringBuilder str=new StringBuilder();
        List<StringBuilder> rows=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        int curr=0;
        boolean direction=false; //true-going down, false-going up
        for(char c:s.toCharArray()){
            rows.get(curr).append(c);
            if(curr==0 || curr==numRows-1){
                direction=!direction;
            }
            curr+=direction?1:-1;
        }
        for(int i=0;i<numRows;i++){
            str.append(rows.get(i));
        }
        return str.toString();        
    }
}