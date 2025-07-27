class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adj=new HashMap<>();
        for(int i=-1;i<wordList.size();i++){
            if(i==-1){
                adj.put(beginWord, new ArrayList<>());
            }else{
                adj.put(wordList.get(i), new ArrayList<>());
            }
        }
        for(String word:wordList){
            if(isOneLetterDiff(beginWord, word)){
                adj.get(beginWord).add(word);
                adj.get(word).add(beginWord);
            }
        }
        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                if(isOneLetterDiff(wordList.get(i), wordList.get(j))){
                    adj.get(wordList.get(i)).add(wordList.get(j));
                    adj.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        Set<String> visit=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        visit.add(beginWord);
        int count=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                 String curr=q.poll();
                if(curr.equals(endWord)) return count;
                for(String n:adj.get(curr)){
                    if(!visit.contains(n)){
                        q.add(n);
                        visit.add(n);
                    }
                }
            }
            count++;
        }
        return 0;
    }
    private boolean isOneLetterDiff(String w1, String w2){
        if(w1.length()!=w2.length()) return false;
        int diff=0;
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i)) diff++;
        }
        return diff==1;
    }
}