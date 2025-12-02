class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num=new ArrayList<>();
        for(int i=1;i<=n;i++) num.add(i);
        StringBuilder sb=new StringBuilder();
        int fact[]=new int[n];
        fact[0]=1;
        for(int i=1;i<n;i++) fact[i]=fact[i-1]*i;
        k--;
        for(int i=n;i>=1;i--){
            int idx=k/fact[i-1];
            sb.append(num.get(idx));
            num.remove(idx);
            k%=fact[i-1];
        }
        return sb.toString();
    }
}