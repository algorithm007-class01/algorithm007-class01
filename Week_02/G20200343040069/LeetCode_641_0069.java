import java.util.HashMap;

public class LeetCode_641_0069 {
    class MyCircularDeque {
        int[] myqueue;
        int head;
        int tail;
        int n;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            n = k+1;
            myqueue = new int[n];
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull()) {
                return false;
            }else{
                head = (head-1 +n) % n;
                myqueue[head]=value;

            }
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }else{
                myqueue[tail]=value;
                tail = (tail + 1) %n;
            }
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(isEmpty()) {
                return false;
            }else{
                head = (head+1)%n;
            }
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }else{
                tail = (tail-1 +n )%n;
            }
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(isEmpty()) return -1;
            return myqueue[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(isEmpty()) return -1;

            return myqueue[(tail -1 + n) %n];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return head == tail;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (tail +1) % n == head;
        }
    }
}
