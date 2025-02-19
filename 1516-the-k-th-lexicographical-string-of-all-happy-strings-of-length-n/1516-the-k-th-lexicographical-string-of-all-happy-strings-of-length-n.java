class Solution {
    public String getHappyString(int n, int k) {
        char [] avail={'a', 'b', 'c'};
        List<String> allStrings=new ArrayList<>();
        backtrack(allStrings, "", n, avail);
        if(k<=allStrings.size()){
            return allStrings.get(k-1);
        }else{
            return "";
        }
    }
    public void backtrack(List<String> allStrings, String curr, int n, char[] ch){
        if(curr.length()==n){
            allStrings.add(curr);
            return;
        }
        for(char c:ch){
            if(curr.length()==0 || curr.charAt(curr.length()-1)!=c){
                backtrack(allStrings, curr+c, n, ch);
            }
        }
    }
}