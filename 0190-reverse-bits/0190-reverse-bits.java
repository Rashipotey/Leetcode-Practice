class Solution {
    public int reverseBits(int n) {
        String bin=String.format("%32s",Integer.toBinaryString(n)).replace(' ','0');
        StringBuilder sb=new StringBuilder(bin).reverse();
        return Integer.parseInt(sb.toString(),2);
    }
}