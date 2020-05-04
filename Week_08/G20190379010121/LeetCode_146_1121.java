class LRUCache {
    private HashMap<Integer,Node> cache = new HashMap<>();
    private int cap,size;
    private Node head,tail;

    class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;
    }

    private void moveToHead(Node node){
        removeNode(node);
        insertNode(node);
    }
    private void removeNode(Node node){
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    private void insertNode(Node node){
        node.pre = head;
        node.next = head.next;

        head.next = node;
        node.next.pre = node;
    }

    private Node popTail(){
        Node tail = this.tail.pre;
        removeNode(tail);
        return tail;
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            node = new Node();
            node.key = key;
            node.value = value;

            cache.put(key,node);
            insertNode(node);
            size ++;

            if(size > cap){
                Node tail = popTail();
                cache.remove(tail.key);
                size --;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */