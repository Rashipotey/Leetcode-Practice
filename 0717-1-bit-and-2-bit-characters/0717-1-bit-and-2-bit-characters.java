class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        for(i=0;i<bits.length-1;i++){
            if(bits[i]==1 && (bits[i+1]==0 || bits[i+1]==1)){
                i++;
            }
            else if(bits[i]==0) continue;
            else return false;
        }
        if(i<bits.length && bits[i]==0) return true;
        return false;
    }
}