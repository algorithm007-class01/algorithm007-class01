/**
 * 641. 设计循环双端队列
 * 设计实现双端队列。
    你的实现需要支持以下操作：

    MyCircularDeque(k)：构造函数,双端队列的大小为k。
    insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
    insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
    deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
    deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
    getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
    getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
    isEmpty()：检查双端队列是否为空。
    isFull()：检查双端队列是否满了。
 * 第三种方法：链表 + size
 *  1. 定义循环变量 frontNode 和 rearNode
 *      frontNode 代表第一个有效数据 Node
 *      rearNode 代表最后一个有效数据 Node
 *      初始化 insertFront 或者 insertLast 的时候，frontNode == rearNode
 *  2. 增加 size 变量表示队列长度
 *      队列为空：size == 0
 *      队列满额：size == capacity
 * 执行时间：4~5 ms
 */
class MyCircularDeque {
    private int capacity;
    private int size;
    private Node frontNode;
    private Node rearNode;

    private class Node {
        int val;
        Node prev;
        Node next;

        public Node (int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        Node newNode = new Node(value);

        if (this.frontNode == null) {
            this.frontNode = newNode;
        } else{
            this.frontNode.prev = newNode;
            newNode.next = this.frontNode;
            this.frontNode = newNode;
        }

        if (this.rearNode == null) {
            this.rearNode = this.frontNode;
        }

        size++;

        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        
        Node newNode = new Node(value);

        if (this.rearNode == null) {
            this.rearNode = newNode;
        } else {
            this.rearNode.next = newNode;
            newNode.prev = this.rearNode;
            this.rearNode = newNode;
        }

        if (this.frontNode == null) {
            this.frontNode = this.rearNode;
        }

        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (this.frontNode.next == null) {
            this.frontNode = null;
            this.rearNode = null;
        } else {
            this.frontNode.next.prev = null;
            this.frontNode = this.frontNode.next;
        }

        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (this.rearNode.prev == null) {
            this.rearNode = null;
            this.frontNode = null;
        } else {
            this.rearNode.prev.next = null;
            this.rearNode = this.rearNode.prev;
        }
        
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return frontNode.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return rearNode.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */