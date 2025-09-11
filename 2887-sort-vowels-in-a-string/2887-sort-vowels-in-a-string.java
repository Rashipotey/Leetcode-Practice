class Solution {
    public String sortVowels(String s) {
        List<Character> l=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                l.add(s.charAt(i));
                sb.append('0');
            }else{
                sb.append(s.charAt(i));
            }
        }
        Collections.sort(l);
        for(int i=0, j=0;i<s.length() && j<l.size();i++){
            if(sb.charAt(i)=='0'){
                sb.setCharAt(i,l.get(j++));
            }
        }
        return sb.toString();
    }
    private boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
            return true;
        }
        return false;
    }
}