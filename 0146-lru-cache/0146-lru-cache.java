class LRUCache {
    class Node{
        int val, key;
        Node prev, next;
        Node(int key, int val){
            this.val=val;
            this.key=key;
        }
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    final int capacity;
    Map<Integer, Node> map=new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    private void addNode(Node newNode){
        newNode.next=head.next;
        newNode.prev=head;
        head.next.prev=newNode;
        head.next=newNode;
    }

    private void deleteNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
    public int get(int key) {
        Node node=map.get(key);
        if(node==null) return -1;
        deleteNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        Node node=map.get(key);
        if(node!=null){
            node.val=value;
            deleteNode(node);
            addNode(node);
            return;
        }
        if(map.size()==capacity){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        map.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */