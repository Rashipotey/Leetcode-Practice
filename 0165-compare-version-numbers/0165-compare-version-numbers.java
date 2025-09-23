class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1=version1.split("\\.");
        String[] str2=version2.split("\\.");
        int n=str1.length, m=str2.length;
        int res=0;
        int l=Math.max(n,m);
       for(int i=0;i<l;i++){
            int val1=i<n?Integer.parseInt(str1[i]):0;
            int val2=i<m?Integer.parseInt(str2[i]):0;
            if(val1<val2) return -1;
            else if(val1>val2) return 1;
        }
        return 0;
    }
}