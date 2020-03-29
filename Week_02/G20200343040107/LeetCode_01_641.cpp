#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std; 

class MyCircularDeque {
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        data = new int[k+1];
        capacity = k + 1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if(isFull()) {
            return false;
        }

        head = (head - 1 + capacity) % capacity;
        data[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if(isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if(isEmpty()) {
            return false;
        }

        tail = (tail - 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the deque. */
    int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return data[(tail - 1 + capacity)%capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return (tail+1)%capacity == head;
    }

private:
    int *data = nullptr;
    int head = 0;
    int tail = 0;
    int capacity = 0;
};

void test_case() {
    // 在leetcode已经测试过
}
int main(int argc, char* argv) {
    test_case();
	return 0; 
}