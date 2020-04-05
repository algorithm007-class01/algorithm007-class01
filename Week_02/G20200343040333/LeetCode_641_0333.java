package app;

public class LeetCode_641_0333 {
    /**
     * array to implements 
     */
    class MyCircularDeque {
        int[] mAarry=null;
        int cap=0;
        int head=0;
        int tail=0;
        int length=0;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            
            cap=k+1;// 双端队列 空出一个不存值
            mAarry=new int[cap];
        }
    
        /**
         * Adds an item at the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertFront(int value) {
            if ( isFull() ) return false;
            head=((head-1)+cap)%cap;
            mAarry[head]=value;
            length++;
            return true;
        }
    
        /**
         * Adds an item at the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertLast(int value) {
            if ( isFull() ) return false;
            mAarry[tail]=value;
            tail=(tail+1)%cap;
            length++;
            return true;
        }
    
        /**
         * Deletes an item from the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteFront() {
            if(isEmpty()) return false;
            mAarry[head]=0;
            head=(head+1)%cap;
            length--;
            return true;
        }
    
        /**
         * Deletes an item from the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteLast() {
            if(isEmpty()) return false;
            mAarry[tail]=0;
            tail=(tail-1+cap)%cap;
            length--;
            return true;
    
        }
    
        /** Get the front item from the deque. */
        public int getFront() {
            if(isEmpty()) return -1;
            return mAarry[head];
        }
    
        /** Get the last item from the deque. */
        public int getRear() {
            if(isEmpty())return -1;
            return mAarry[((tail-1)+cap)%cap];
        }
    
        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return tail==head;
        }
    
        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (tail+1)%cap==head;
        }
    }
    
    
    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
     * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
     * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
     * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
     * obj.isEmpty(); boolean param_8 = obj.isFull();
     */
}