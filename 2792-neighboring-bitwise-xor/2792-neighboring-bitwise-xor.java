class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor=0;
        for(int i=0;i<derived.length;i++){
            xor^=derived[i];
        }
        return xor==0;
    }
}