class MyCircularDeque {
      /**
       *
       * 参考题解：数组实现的循环双端队列 - liweiwei1419，进行实现
       *
       * 前导题：622.设计循环队列
       *
       * 实现思路：
       *    使用循环数组进实现
       *    设计 front 和 rear 两个指针变量分别指向对头和队尾
       *    当 front == rear 时，队列为空
       *    当(rear + 1) % capacity == front 时，队列为满
       *    备注：为了避免“队列为空”和“队列为满”的判别条件冲突，我们有意浪费了一个位置。
       * **/

      private int capacity;// 队列容量
      private int[] arr;// 使用数组实现队列
      private int front;// 头部指针
      private int rear;// 尾部指针

    /** Initialize your data structure here. Set the size of the deque to be k. */
    // MyCircularDeque(k)：构造函数,双端队列的大小为k。
    public MyCircularDeque(int k) {
        capacity = k + 1;

        arr = new int[capacity];

        // 头部指向第 1 个存放元素的位置
        // 插入时，往前，先减，再赋值
        // 删除时，往后，索引 +1（注意取模）
        front = 0;

        // 尾部指向下一个插入元素的位置
        // 插入时，往后，先赋值，再加
        // 删除时，往前，索引 -1（注意取模）
        rear = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    // insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        // 头部插入时，往前，先减，再赋值（注意：指针前移的时候，为了循环到数组的末尾，需要先加上数组的长度，然后再对数组长度取模。）
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    // insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        // 尾部插入时，先赋值，再加
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    // deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        // 头部删除时，往后，索引+1（注意取模）(注意，front为头部，所以+1就行)
        front = (front + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    // deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        // 从尾部删除时，往前，索引-1（注意取模）（注意：指针前移的时候，为了循环到数组的末尾，需要先加上数组的长度，然后再对数组长度取模。）
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }
    
    /** Get the front item from the deque. */
    // getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    /** Get the last item from the deque. */
    // getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];// 注意：当 rear 为 0 时防止数组越界
    }
    
    /** Checks whether the circular deque is empty or not. */
    // isEmpty()：检查双端队列是否为空。
    public boolean isEmpty() {
        return (front == rear);
    }
    
    /** Checks whether the circular deque is full or not. */
    // isFull()：检查双端队列是否满了。
    public boolean isFull() {
        return (rear + 1) % capacity == front;// 注意：这个设计是非常经典的做法
    }
}