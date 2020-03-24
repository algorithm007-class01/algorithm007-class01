

/**
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了
 * */
public class LeetCode_641_0145 {

}
class MyCircularDeque{
    private int capacity;
    private int[] data;
    private int front;
    private int rear;

    public MyCircularDeque(int k) {
        // 保留一个冗余空间，用来判断队列是否是满的，防止值的覆盖
        capacity = k + 1;
        data = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            // 队列满了
            return false;
        }
        // 添加,判断front
        if (front == 0) {
            front = capacity - 1;
        } else {
            front -= 1;
        }
        data[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        data[rear] = value;
        if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear += 1;
        }
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        // 删除第一个
        if (isEmpty()) {
            return false;
        }
        if (front == capacity - 1) {
            front = 0;
        } else {
            front += 1;
        }
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear -= 1;
        }
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        if (rear == 0) {
            return data[capacity - 1];
        } else {
            return data[rear - 1];
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        // 判空，开始、结束指针指向同一个位置
        return front == rear;
    }

    /**
     * 判断队列是否是满的
     */
    public boolean isFull() {
        //  1.front和rear的值一定小于 capacity
        //  2.队列满的时候，rear下一个位置就是front
        return ((rear + 1) % capacity) == front;
    }
}
