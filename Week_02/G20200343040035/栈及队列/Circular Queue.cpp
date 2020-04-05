class MyCircularQueue {
private:
    vector<int> data;
    int size;
    int head;
    int tail;
public:
    /** Initialize your data structure here. Set the size of the queue to be k. */
    MyCircularQueue(int k) {
        data.resize(k+1);
        size = k + 1;
        head = 0;
        tail = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    bool enQueue(int value) {
        if (isFull()) return false;
        data[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    bool deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % size;
        return true;
    }
    
    /** Get the front item from the queue. */
    int Front() {
        if (isEmpty()) return -1;
        return data[head];
    }
    
    /** Get the last item from the queue. */
    int Rear() {
        if (isEmpty()) return -1;
        return tail == 0 ? data[size -1] : data[tail -1];

    }
    
    /** Checks whether the circular queue is empty or not. */
    bool isEmpty() {
        return head == tail;
    }
    
    /** Checks whether the circular queue is full or not. */
    bool isFull() {
        return head == (tail + 1) % size;
    }
};
