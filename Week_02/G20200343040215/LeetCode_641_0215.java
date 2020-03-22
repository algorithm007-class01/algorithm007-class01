package DailyPractice;

public class LeetCode_641_0215 {

    int [] queue ;
    int front ;
    int rear;
    int size;
    int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode_641_0215(int k) {
        this.queue = new int [k];
        this.front=0;
        this.rear=0;
        this.size=0;
        this.capacity =k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(front==rear && size==capacity){
            return false;
        }
        front =(front+capacity -1)%capacity;
        queue[front]=value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(front==rear && size==capacity){
            return false;
        }
        queue[rear]=value;
        rear =(rear+capacity +1)%capacity;

        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size==0){
            return false;
        }

        front =(front+capacity +1)%capacity;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size==0){
            return false;
        }
        rear =(rear+capacity -1)%capacity;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size==0){
            return -1;
        }

        return queue[front];

    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size==0){
            return -1;
        }

        return queue[(rear-1+capacity)%capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==capacity;

        PriorityQueue
    }

}
