class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            int partIndex=s.indexOf(part);
            s=s.substring(0,partIndex)+s.substring(partIndex+part.length());
        }
        return s;
    }
}