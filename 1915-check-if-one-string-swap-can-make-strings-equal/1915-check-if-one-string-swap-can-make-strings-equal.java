class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int firstID=0, secondID=0;
        int numDiff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                numDiff++;
                if(numDiff>2){
                    return false;
                }else if(numDiff==1){
                    firstID=i;
                }else{
                    secondID=i;
                }
            }
        }
        return (s1.charAt(firstID)==s2.charAt(secondID) && s1.charAt(secondID)==s2.charAt(firstID));
    }
}