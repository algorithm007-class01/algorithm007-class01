/**
 * 双链表实现
 * insert: O(1)
 * delete: O(1)
 * getFront: O(1)
 * getRear: O(1)
 */
class MyCircularDeque {

    private class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;
    int size, count;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {

        head = new ListNode(0);
        tail = new ListNode(0);

        size = k;
        count = 0;

        head.next = tail;
        tail.prev = head;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;

        ++count;
        ListNode temp = new ListNode(value);

        temp.next = head.next;
        temp.prev = head;
        head.next.prev = temp;
        head.next = temp;

        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;

        ++count;
        ListNode temp = new ListNode(value);

        temp.prev = tail.prev;
        temp.next = tail;
        tail.prev.next = temp;
        tail.prev = temp;

        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;

        --count;

        ListNode temp = head.next;
        head.next = temp.next;
        temp.next.prev = head;

        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;

        --count;

        ListNode temp = tail.prev;
        tail.prev = temp.prev;
        temp.prev.next = tail;

        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return head.next.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return tail.prev.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     * 如果头结点后面既是尾结点，则队列为空。
     */
    public boolean isEmpty() {
        return head.next == tail;
    }

    /**
     * Checks whether the circular deque is full or not.
     * 如果节点数 >= size，则队列已满。
     */
    public boolean isFull() {
        return count >= size ? true : false;
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