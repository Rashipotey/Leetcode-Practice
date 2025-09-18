class TaskManager {
    static class Task{
        int userId, taskId, priority;
        Task(int userId, int taskId, int priority){
            this.userId=userId;
            this.taskId=taskId;
            this.priority=priority;
        }
    }
    Map<Integer, Task> taskMap;
    PriorityQueue<Task> maxHeap; 
    public TaskManager(List<List<Integer>> tasks) {
        taskMap=new HashMap<>();
        maxHeap=new PriorityQueue<>((a,b)->{
            if(b.priority!=a.priority) return b.priority-a.priority;
            else if(b.taskId!=a.taskId) return b.taskId-a.taskId;
            return b.userId-a.userId;
        });
        for(List<Integer> l:tasks){
            int userId=l.get(0), taskId=l.get(1), priority=l.get(2);
            Task t=new Task(userId, taskId, priority);
            taskMap.put(taskId,t);
            maxHeap.add(t);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task t=new Task(userId, taskId, priority);
        taskMap.put(taskId,t);
        maxHeap.add(t);
    }
    
    public void edit(int taskId, int newPriority) {
        if(!taskMap.containsKey(taskId)) return;
        Task old=taskMap.get(taskId);
        taskMap.remove(taskId);
        Task tnew=new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId,tnew);
        maxHeap.add(tnew);
    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        while(!maxHeap.isEmpty()){
            Task top=maxHeap.peek();
            if(taskMap.containsKey(top.taskId) && taskMap.get(top.taskId).priority==top.priority){
                maxHeap.poll();
                taskMap.remove(top.taskId);
                return top.userId;
            }else{
                maxHeap.poll();
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */