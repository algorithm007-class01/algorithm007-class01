class MyCircularDeque {
    private final int[] queue;
    private int front;
    private int rear;
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */

    public MyCircularDeque(int k) {
        this.queue = new int[k + 1];
        //初始化的时候，头  尾 在同一个起点只是方向不一样
        // front 是没有值的
        // rear在启示位置被认为是有值的，所以这里k+1，这里也影响了isFull的判断
        this.front = 0;
        this.rear = 0;
        this.capacity = k + 1;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        // 队列已经满了，不能在插入了;
        if (isFull()) {
            return false;
        }
        //直接插入，然后计算头指针
        //fornt 位置没有元素
        queue[front] = value;
        front = (front + 1) % capacity;
        return true;

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        // 计算下一个rear
        // 如果rear =0 k =4 capacity =5
        // rear= (0-1+5)%5=4 [0] [1]  [2]  [3] [4] 也就是说下一个rear 在queue[4] 这样计算刚好循环在数组末尾
        // 当前rear 位置有元素，与front 区别
        rear = (rear - 1 + capacity) % capacity;
        queue[rear] = value;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        // 如果front 3 .rear =1
        // 那么删除一个元素后rear应该是向前跑一个位置，所以这里是+1
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return isEmpty() ? -1 : queue[(front - 1 + capacity) % capacity];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return isEmpty() ? -1 : queue[rear];
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
        // 如果头指针的下一个指针是尾指针，则认为队列已经满了
        // 满的时候 front 的下一个与 rear 相遇，这个是+1 的位置
        return (front + 1) % capacity == rear;
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