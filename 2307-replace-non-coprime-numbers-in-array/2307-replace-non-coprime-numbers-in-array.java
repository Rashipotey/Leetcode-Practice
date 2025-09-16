class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> li=new ArrayList<>();
        for(int n:nums){
            while(li.size()>=1){
                int hcf=gcd(li.get(li.size()-1),n);
                if(hcf==1) break;
                int last=li.remove(li.size()-1);
                n=lcm(n,last,hcf);
            }
            li.add(n);
        }
        return li;
    }
    private int gcd(int a, int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    private int lcm(int a, int b, int gcd){
        return (a/gcd)*b;
    }
}