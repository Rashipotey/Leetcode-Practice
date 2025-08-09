class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression);
    }
    private List<Integer> helper(String exp){
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                String le=exp.substring(0,i);
                String re=exp.substring(i+1);
                List<Integer> left=helper(le);
                List<Integer> right=helper(re);
                for(int l:left){
                    for(int r:right){
                        int ans=0;
                        if(c=='+') ans=l+r;
                        else if(c=='-') ans=l-r;
                        else ans=l*r;
                        res.add(ans);
                    }
                }
            }
        }
        if(res.isEmpty()) res.add(Integer.parseInt(exp));
        return res;
    }
}