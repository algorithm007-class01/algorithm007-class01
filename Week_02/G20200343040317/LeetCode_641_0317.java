
class MyCircularDeque {

    private final int[] data;
    // front 位置是没有数据的
    // rear 位置是有数据的
    // 指针在做 -1 操作的时候记得需要 +cap 后再模 ，这样才会回到头
    private int front;
    private int rear;
    private int cap;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        cap = k + 1;
        data = new int[cap];
        front = 0;
        rear = 0;

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    
    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        data[front] = value;
        front = (front + 1) % cap;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear - 1 + cap) % cap;
        data[rear] = value;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front - 1 + cap) % cap;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear + 1) % cap;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return isEmpty() ? -1 : data[(front - 1 + cap) % cap];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return isEmpty() ? -1 : data[rear];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (front + 1) % cap == rear;
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