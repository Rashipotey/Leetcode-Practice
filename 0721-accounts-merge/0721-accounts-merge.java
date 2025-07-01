class Solution {
    Map<String,List<String>> adj=new HashMap<>();
    Set<String> visit=new HashSet<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            List<String> curr=accounts.get(i);
            String firstEmail=curr.get(1);
            adj.putIfAbsent(firstEmail,new ArrayList<>());
            for(int j=2;j<curr.size();j++){
                String currEmail=curr.get(j);
                adj.putIfAbsent(currEmail, new ArrayList<>());
                adj.get(currEmail).add(firstEmail);
                adj.get(firstEmail).add(currEmail);
            }
        }
        for(List<String> accountDet:accounts){
            String name=accountDet.get(0);
            String firstEmail=accountDet.get(1);
            if(!visit.contains(firstEmail)){
                List<String> acc=new ArrayList<>();
                acc.add(name);
                dfs(acc,firstEmail);
                Collections.sort(acc.subList(1,acc.size()));
                res.add(acc);
            }
        }
        return res;
    }
    private void dfs(List<String> acc,String email){
        visit.add(email);
        acc.add(email);
        if(!adj.containsKey(email)) return;
        for(String nextEmail:adj.get(email)){
            if(!visit.contains(nextEmail)){
                dfs(acc,nextEmail);
            }
        }
    }
}