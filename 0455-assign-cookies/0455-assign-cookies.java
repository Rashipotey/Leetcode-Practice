class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0, ind=0;
        while(ind<s.length && res<g.length){
            if(s[ind]>=g[res]){
                res++;
            }
            ind++;
        }
        return res;
    }
}