class MyCircularDeque {
private:
    vector<int> arr;
    int front;
    int rear;
    int capacity;

public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        capacity = k + 1;
        arr.assign(capacity, 0);

        front = 0;
        rear = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (isFull()) {
            return false;
        }

        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (isFull()) {
            return false;
        }

        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        return true;

    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (isEmpty()) {
            return false;
        }

        rear = (rear - 1 + capacity) % capacity;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (isEmpty()) {
            return  -1;
        }
        
        return arr[front];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[(rear - 1 + capacity) % capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return front == rear;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return (rear + 1) % capacity == front;
    }
};
