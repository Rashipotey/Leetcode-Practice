class Solution {
    private static final Map<Character, String> map=Map.of(
        '2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz"
    );
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
        backtrack(0, digits, new StringBuilder(), res);
        return res;
    }
    public void backtrack(int c, String digits, StringBuilder path, List<String> res){
        if(c==digits.length()){
            res.add(path.toString());
            return;
        }
        String letters=map.get(digits.charAt(c));
        for(char ch:letters.toCharArray()){
            path.append(ch);
            backtrack(c+1,digits,path,res);
            path.deleteCharAt(path.length()-1);
        }
    }
}