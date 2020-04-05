package demo;

/**
 * @author Bai
 */
class MyCircularDeque {
    int length;
    int head;
    int tail;
    Integer[] data;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        length = k;
        data = new Integer[k];
        head = k / 2;
        tail = head;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if ((tail - head + 1) == length) {
            return false;
        }
        if (head != 0) {
            head--;
            data[head] = value;
        } else {
            System.arraycopy(data, head, data, head + 1, tail - head);
            data[head] = value;
            tail++;
        }
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if ((tail - head + 1) == length) {
            return false;
        }
        if (tail != length - 1) {
            data[tail + 1] = value;
            tail++;
        } else {
            System.arraycopy(data, head, data, head - 1, tail - head);
            data[tail] = value;
            head--;
        }
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (head == tail) {
            return false;
        }
        head++;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (tail == head) {
            return false;
        }
        tail--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (head == tail) {
            return -1;
        }
        return data[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (head == tail) {
            return -1;
        }
        return data[tail];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (tail - head + 1) == length;
    }
}
