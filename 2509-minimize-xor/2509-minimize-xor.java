class Solution {
    public int minimizeXor(int num1, int num2) {
        int bit1=Integer.bitCount(num1);
        int bit2=Integer.bitCount(num2);
        int res=num1, curr=0;
        while(bit1<bit2){
            if(!isSet(res, curr)){
                res=setBit(res,curr);
                bit1++;
            }
            curr++;
        }
        while(bit1>bit2){
            if(isSet(res, curr)){
                res=unsetBit(res,curr);
                bit1--;
            }
            curr++;
        }
        return res;
    }

    public boolean isSet(int x, int bit){
        return (x&(1<<bit))!=0;
    }

    public int setBit(int x, int bit){
        return x|(1<<bit);
    }

    public int unsetBit(int x, int bit){
        return x&~(1<<bit);
    }
}