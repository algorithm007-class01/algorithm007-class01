public class LeetCode_641_0241 {

    /*设计实现双端队列。
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
    示例：

    MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
    circularDeque.insertLast(1);			        // 返回 true
    circularDeque.insertLast(2);			        // 返回 true
    circularDeque.insertFront(3);			        // 返回 true
    circularDeque.insertFront(4);			        // 已经满了，返回 false
    circularDeque.getRear();  				// 返回 2
    circularDeque.isFull();				        // 返回 true
    circularDeque.deleteLast();			        // 返回 true
    circularDeque.insertFront(4);			        // 返回 true
    circularDeque.getFront();				// 返回 4 */
    /**
     * 我的数组实现，时间复杂度太高
     */
    class MyCircularDeque {
        private int[] elements;
        private int size;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            elements = new int[k];
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull()) return false;
            for(int i = size -1;i >= 0;i--){
                elements[i+1] = elements[i];
            }
            elements[0] = value;
            size++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull()) return false;

            elements[size] = value;
            size++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(isEmpty()) return false;
            for(int i = 0;i < size-1;i++){
                elements[i] = elements[i=1];
            }
            size--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(isEmpty()) return false;
            elements[size-1] = 0;
            size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return size == 0 ? -1 :elements[0];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return size ==0 ? -1 : elements[size-1];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == elements.length;
        }
    }

    /**
     * 优化
     */
    class MyCircularDequeCopy {
        int[] a;
        int front, rear, cap;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDequeCopy(int k) {
            a = new int[k + 1];
            front = 0;
            rear = 0;
            cap = k + 1;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull()) return false;
            a[front] = value;
            front = (front + 1) % cap;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull()) return false;
            rear = (rear - 1 + cap) % cap;
            a[rear] = value;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(isEmpty()) return false;
            front = (front - 1 + cap) % cap;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(isEmpty()) return false;
            rear = (rear + 1) % cap;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return isEmpty() ? -1 : a[(front - 1 + cap) % cap];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return isEmpty() ? -1 : a[rear];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return front == rear;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (front + 1) % cap == rear;
        }
    }
}
