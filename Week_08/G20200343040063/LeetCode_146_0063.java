public class LRUCache {

    private HashMap<Integer,Node> map;
    private DoubleList list ;
    private int size;

    public LRUCache(int size){
        this.size = size;
        this.map = new HashMap<>();
        list = new DoubleList();
    }

    public int get(int key){
        Node node = map.get(key);
        if(node != null){
            put(node.key,node.val);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int val){
        Node newNode = new Node(key, val);
        Node node = map.get(key);
        if(node != null){
            list.remove(node);
            list.addFirst(newNode);
        }else {
            if(size == map.size()){
                Node last = list.removeLast();
                map.remove(last.key);
            }
            list.addFirst(newNode);
        }
        map.put(key,newNode);
    }

}

class Node {

    public int key;
    public int val;

    public Node prev;

    public Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }

}

class DoubleList {

    private Node head;

    private Node tail;

    private int size;

    public DoubleList(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node x){
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeLast(){
        if(tail.prev == null){
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size(){
        return size;
    }
}