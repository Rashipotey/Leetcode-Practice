class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] str=text.split(" ");
        Set<Character> set=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }
        int count=0;
        for(int i=0;i<str.length;i++){
            boolean isBroken=false;
            for(int j=0;j<str[i].length();j++){
                if(set.contains(str[i].charAt(j))){
                    isBroken=true;
                    break;
                }
            }
            if(!isBroken) count++;
        }
        return count;
    }
}