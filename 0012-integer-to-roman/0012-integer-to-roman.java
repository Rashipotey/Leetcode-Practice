class Solution {
    public String intToRoman(int num) {
        StringBuilder str=new StringBuilder();
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for(int i=0;num>0;i++){
            while(num>=values[i]) {
                str.append(rom[i]); 
                num-=values[i]; 
            }
        }
        return str.toString();
    }
}