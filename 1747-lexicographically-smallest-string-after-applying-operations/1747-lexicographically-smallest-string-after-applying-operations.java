class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visit=new HashSet<>();
        PriorityQueue<String> pq=new PriorityQueue<>();
        pq.add(s);
        String min=s;
        while(!pq.isEmpty()){
            String curr=pq.poll();
            int n=curr.length();
            if(visit.contains(curr)) continue;
            visit.add(curr);
            if(curr.compareTo(min)<0) min=curr;
            StringBuilder sb=new StringBuilder(curr);
            for(int i=0;i<n;i++){
                if((i&1)==1){
                    int digit=(sb.charAt(i)-'0'+a)%10;
                    sb.setCharAt(i,(char)(digit+'0'));
                }
            }
            String str=sb.toString();
            if(!visit.contains(str)) pq.add(str);

            String rotated=curr.substring(n-b)+curr.substring(0,n-b);
            if(!visit.contains(rotated)) pq.add(rotated);
        }
        return min;
    }
}