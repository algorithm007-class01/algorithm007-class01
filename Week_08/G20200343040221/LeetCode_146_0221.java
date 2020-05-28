//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
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
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// 146. LRU缓存机制
public class LruCache_146 {

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private static final int NOT_FOUND = -1;

    private final int capacity;
    private final Map<Integer, LruNode> CACHE;

    private int size;

    private LruNode head;
    private LruNode tail;

    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity is " + capacity + ", must great than 0!");
        }
        this.capacity = capacity;
        this.CACHE = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if (size == 0) {
            return NOT_FOUND;
        }

        if (head.getKey() == key) {
            return head.getValue();
        }

        LruNode node = CACHE.get(key);
        if (node == null) {
            return NOT_FOUND;
        }

        return asHead(node).getValue();
    }
    
    public void put(int key, int value) {
        Integer objectKey = key;
        LruNode node = CACHE.get(objectKey);
        if (node == null) {
            node = new LruNode(key, value);

            if (head == null) {
                head = tail = node;
            } else {
                head.setPrev(node);
                node.setNext(head);
                head = node;
            }

            CACHE.put(objectKey, node);

            if (size == capacity) {
                LruNode oldTail = tail;
                tail = oldTail.getPrev().setNext(null);
                CACHE.remove(oldTail.getKey());
            } else {
                size += 1;
            }
        } else {
            node.setValue(value);

            if (node != head) {
                asHead(node);
            }
        }
    }

    private LruNode asHead(LruNode node) {
        LruNode prev = node.getPrev();
        if (node == tail) {
            prev.setNext(null);
            tail = prev;
        } else {
            LruNode next = node.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }

        node.setPrev(null);
        node.setNext(head);
        head.setPrev(node);

        head = node;

        return node;
    }
}

class LruNode {

    private final int key;
    private int value;

    private LruNode prev;
    private LruNode next;

    public LruNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LruNode getPrev() {
        return prev;
    }

    public LruNode setPrev(LruNode prev) {
        this.prev = prev;
        return this;
    }

    public LruNode getNext() {
        return next;
    }

    public LruNode setNext(LruNode next) {
        this.next = next;
        return this;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
