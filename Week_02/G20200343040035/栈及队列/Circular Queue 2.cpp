//循环双端队列

class MyCircularDeque {
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        m_head = 0;
        m_tail = 0;
        m_size = 0;
        m_capacity = k;
        m_arr = new int[k];
    }


    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (isFull())
            return false;
        
        //head指向当前元素， 前插时，head逆时针旋转
        --m_head;
        if (m_head < 0)
        {
            m_head = m_capacity - 1;
        }

        m_arr[m_head] = value;

        ++m_size;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (isFull())
            return false;

        m_arr[m_tail++] = value;
        if (m_tail == m_capacity)
        {
            m_tail = 0;
        }

        ++m_size;

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (isEmpty())
            return false;

        //从头删除 head顺时针旋转
        ++m_head;
        if (m_head == m_capacity)
        {
            m_head = 0;
        }

        --m_size;

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (isEmpty())
            return false;

        --m_tail;
        if (m_tail < 0)
        {
            m_tail = m_capacity - 1;
        }

        --m_size;

        return true;
    }

    /** Get the front item from the deque. */
    int getFront() {
        if (isEmpty())
            return -1;

        return m_arr[m_head];
    }

    /** Get the last item from the deque. */
    int getRear() {
        if (isEmpty())
            return -1;

        //注意：最后元素的索引是m_tail的上一个元素
        int index = m_tail - 1;
        if (index < 0)
        {
            index = m_capacity - 1;
        }
        return m_arr[index];
    }

    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return m_size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return m_size == m_capacity;
    }


private:
    int* m_arr;
    int m_head;
    int m_tail;
    int m_size;  //元素个数
    int m_capacity; //容量 固定长度
};