class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visit=new HashSet<>(wordList);
        if (!visit.contains(endWord)) return 0;
        Queue<String> q=new LinkedList<>();
        int level=1;
        q.add(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                char[] ch=word.toCharArray();
                for(int j=0;j<ch.length;j++){
                    char originalChar=ch[j];
                    for(char k='a';k<='z';k++){
                        if(ch[j]==k) continue;
                        ch[j]=k;
                        String nW=new String(ch);
                        if(nW.equals(endWord)) return level+1;
                        if(visit.contains(nW)) {
                            q.add(nW);
                            visit.remove(nW);
                        }
                    }
                    ch[j]=originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}