class Solution {
    public boolean isValid(String pattern, List<Integer> currNum, int digit){
        int n=currNum.size();
        if(n==0){
            return true;
        }
        if(pattern.charAt(n-1)=='I' && currNum.get(n-1)<digit){
            return true;
        }
        if (pattern.charAt(n-1)=='D' && currNum.get(n-1)>digit){
            return true;  
        }
        return false;
    }
    public String findNum(String pattern, List<Integer> currNum, List<Integer> avail){
        if(currNum.size()==pattern.length()+1){
            String num="";
            for(int n:currNum){
                num=num+n;
            }
            return num;
        }
        for(int i=0;i<avail.size();i++){
            int digit=avail.get(i);
            if(isValid(pattern,currNum,digit)){
                currNum.add(digit);
                List<Integer> newAvailDigits=new ArrayList<>(avail);
                newAvailDigits.remove(i);
                
                String result=findNum(pattern, currNum, newAvailDigits);
                if(result!=null){
                    return result;
                }
                currNum.remove(currNum.size()-1);
            }
        }
        return null;
    }
    public String smallestNumber(String pattern) {
        String num="";
        List<Integer> avail=new ArrayList<>();
        for(int i=1;i<=9;i++){
            avail.add(i);
        }
        List<Integer> currNum=new ArrayList<>();
        return findNum(pattern, currNum, avail);
    }
}