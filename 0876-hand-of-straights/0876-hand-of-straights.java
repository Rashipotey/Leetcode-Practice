class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        Map<Integer, Integer> m=new TreeMap<>();
        for(int num:hand){
            m.put(num,m.getOrDefault(num,0)+1);
        }
        while(m.size()>0){
            int curr=m.entrySet().iterator().next().getKey();
            for(int i=0;i<groupSize;i++){
                if(!m.containsKey(curr+i)) return false;
                m.put(curr+i,m.get(curr+i)-1);
                if(m.get(curr+i)==0) m.remove(curr+i);
            }
        }
        return true;
    }
}