import java.util.Hashtable;
class LRUCache {
    class LRULinkNode {
        int key;
        int value;
        LRULinkNode prev;
        LRULinkNode next;
    }
    
    private void addNode(LRULinkNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LRULinkNode node) {
        LRULinkNode prev = node.prev;
        LRULinkNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(LRULinkNode node) {
        removeNode(node);
        addNode(node);
    }

    private LRULinkNode popTail() {
        LRULinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Hashtable<Integer, LRULinkNode> cache = new Hashtable<Integer, LRULinkNode>();
    private int size;
    private int capacity;
    private LRULinkNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new LRULinkNode();
        tail = new LRULinkNode();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        LRULinkNode node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        LRULinkNode node = cache.get(key);
        if (node == null) {
            LRULinkNode newNode = new LRULinkNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            size++;

            if (size > capacity) {
                LRULinkNode tail =  popTail();
                cache.remove(tail.key);
                size--;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }
}
