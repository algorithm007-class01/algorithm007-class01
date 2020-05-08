//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写
//入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(Node prev, Node next, int key, int val) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }

    private void add(Node curr) {
        Node next = head.next;
        head.next = curr;
        curr.prev = head;
        next.prev = curr;
        curr.next = next;
    }

    private void remove(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    int size;
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node rear;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node(null, rear, 0, 0);
        rear = new Node(head, null, 0, 0);
        head.next = rear;
    }

    public int get(int key) {
        Node curr = map.get(key);
        if (curr == null) return -1;
        remove(curr);
        add(curr);
        return curr.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node curr = new Node(null, null, key, value);
            add(curr);
            map.put(key, curr);
            size++;
            if (size > capacity) {
                Node temp = rear.prev;
                remove(temp);
                map.remove(temp.key);
                size--;
            }
        } else {
            Node n = map.get(key);
            n.val = value;
            remove(n);
            add(n);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
