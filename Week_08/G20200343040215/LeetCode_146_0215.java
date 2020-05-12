import java.util.HashMap;

public class LeetCode_146_0215 {
    public LeetCode_146_0215(int capacity){
        this.size = 0;
        this.capacity = capacity;

        head  = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }


    private void addNode(DlinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DlinkedNode node){
        DlinkedNode prev = node.prev;
        DlinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;

        //node所占内存是如何回收的？
    }

    private void moveToHead(DlinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DlinkedNode popTail(){
        DlinkedNode result = tail.prev;
        removeNode(result);
        return result;
    }

    private HashMap<Integer, DlinkedNode> cache = new HashMap<>();

    private int size;
    private int capacity;
    private DlinkedNode head,tail;


    public int get(int key){
        DlinkedNode node = cache.get(key);
        if (node==null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DlinkedNode node = cache.get(key);
        if (node==null){
            DlinkedNode newNode = new DlinkedNode();
            newNode.key = key;
            newNode.value = value ;
            cache.put(key, newNode);
            addNode(newNode);
            ++size;
            if (size>capacity){
                DlinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }
}

class DlinkedNode{
    int key;
    int value;
    DlinkedNode prev;
    DlinkedNode next;
}
