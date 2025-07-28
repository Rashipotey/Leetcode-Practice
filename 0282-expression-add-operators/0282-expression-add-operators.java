class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        helper(num,target,res,"",0,0,0);
        return res;
    }
    private void helper(String num, int t, List<String> res, String exp, long val, int i, long multed){
        if(i==num.length()){
            if(val==t) res.add(exp);
            return;
        }for(int j=i;j<num.length();j++){
            if(j!=i && num.charAt(i)=='0') break;
            String part=num.substring(i,j+1);
            long curr=Long.parseLong(part);
            if(i==0){
                helper(num,t,res,part,curr,j+1,curr);
            }else{
                helper(num,t,res,exp+'+'+part,val+curr,j+1,curr);
                helper(num,t,res,exp+'*'+part,val-multed+multed*curr,j+1,multed*curr);
                helper(num,t,res,exp+'-'+part,val-curr,j+1,-curr);
            }
        }
    }
}