import java.util.*;

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=1;i<=n;i++){
            int sum=getDigitSum(i);
            map.put(sum,map.getOrDefault(sum,0)+1);
            max=Math.max(max, map.get(sum));
        }
        int result=0;
        for(int count:map.values()){
            if(count==max){
                result++;
            }
        }
        return result;
    }

    private int getDigitSum(int num) {
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
