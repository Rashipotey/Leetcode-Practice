class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map=new HashMap<>();
        for(char task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        List<Map.Entry<Character, Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,(a,b)->b.getValue()-a.getValue());
        int maxFrequency=list.get(0).getValue();
        int maxCount=0;
        for(Map.Entry<Character, Integer> entry : list){
            if(entry.getValue()==maxFrequency){
                maxCount++;
            }
        }
        int partCount=maxFrequency-1;
        int emptySlots=partCount*(n-(maxCount-1));
        int remainingTasks=tasks.length-(maxFrequency*maxCount);
        int idles=Math.max(0,emptySlots-remainingTasks);
        return tasks.length+idles;
    }
}
