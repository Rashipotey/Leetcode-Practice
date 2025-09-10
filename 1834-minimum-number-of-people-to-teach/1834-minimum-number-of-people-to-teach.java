class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m=languages.length;
        Set<Integer>[] userLang=new Set[m+1];
        for(int i=1;i<=m;i++){
            userLang[i]=new HashSet<>();
        }
        for(int i=0;i<m;i++){
            for(int j:languages[i]){
                userLang[i+1].add(j);
            }
        }
        Set<Integer> needToTeach=new HashSet<>();
        List<int[]> incomp=new ArrayList<>();
        for(int[] p:friendships){
            int u=p[0], v=p[1];
            Set<Integer> setU=userLang[u];
            Set<Integer> setV=userLang[v];
            boolean canComm=false;
            for(int lang:setU){
                if(setV.contains(lang)){
                    canComm=true;
                    break;
                }
            }
            if(!canComm){
                incomp.add(new int[]{u,v});
                needToTeach.add(u);
                needToTeach.add(v);
            }
        }
        int[] langC=new int[n+1];
        for(int us:needToTeach){
            for(int lang:userLang[us]){
                langC[lang]++;
            }
        }
        int maxK=0;
        for(int i=1;i<=n;i++){
            maxK=Math.max(maxK, langC[i]);
        }
        return needToTeach.size()-maxK;
    }
}