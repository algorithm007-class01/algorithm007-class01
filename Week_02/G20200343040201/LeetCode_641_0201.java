class LeetCode_641_0201 {

    int[] arr;
    int header = 0;
    int tail = 0;
    int capacity;
    int size = 0;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public LeetCode_641_0201(int k) {
        arr = new int[k];
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (!isEmpty()) {
            header = (header + 1) % capacity;
        }
        arr[header] = value;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (!isEmpty()) {
            if (tail == 0) {
                tail = capacity - 1;
            } else {
                tail--;
            }
        }
        arr[tail] = value;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (size > 1) {
            if (header == 0) {
                header = capacity - 1;
            } else {
                header--;
            }
        }
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (size > 1) {
            tail = (tail + 1) % capacity;
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[header];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[tail];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        LeetCode_641_0201 circularDeque = new LeetCode_641_0201(2); // 设置容量大小为3
        System.out.print(circularDeque.insertFront(7));
        System.out.print(circularDeque.deleteLast());
        System.out.print(circularDeque.getFront());
        System.out.print(circularDeque.insertLast(5));                    // 返回 true
        System.out.print(circularDeque.insertFront(0));                        // 返回 true
        System.out.print(circularDeque.getFront());                // 返回 4
        System.out.print(circularDeque.getRear());                // 返回 2
        System.out.print(circularDeque.getFront());                // 返回 4
        System.out.print(circularDeque.getFront());                // 返回 4
        System.out.print(circularDeque.getRear());                // 返回 4
        System.out.print(circularDeque.insertFront(0));                    // 返回 true
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