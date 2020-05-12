/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */

/**
 * hashmap + linkedlist(双向)
 */
public class LRUCache {
    private Map<Integer,Node> cache = new HashMap<>();
    private int capacity,size;
    private Node head, tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        Node node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        Node node = cache.get(key);
        if(node == null){
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addNode(newNode);
            size++;
            if(size > capacity){
                Node tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    class Node{
        private int key;
        private int value;
        private Node prev;
        private Node next;
        public Node(){

        }
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;

    }
    private Node popTail() {
        Node node = tail.prev;
        moveNode(node);
        return node;
    }

    private void moveToHead(Node node) {
        moveNode(node);
        addNode(node);
    }

    private void moveNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        cache.put(2,2);
        cache.put(3,4);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}