/**
 * 数组方式
 */
class MyCircularDeque {

    int[] items;//队列数组
    int head;//头指针
    int tail;//尾指针
    int capcity;//队列容量

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capcity = k + 1;
        items = new int[capcity];
        head = tail = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }else{
            head = (head - 1 + capcity) % capcity;
            items[head] = value;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }else{
            items[tail] = value;
            tail = (tail + 1) % capcity;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }else{
            head = (head + 1) % capcity;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }else{
            tail = (tail - 1 + capcity) % capcity;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }else{
            return items[head];
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }else{
            return items[(tail - 1 + capcity) % capcity];
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail + 1) % capcity == head;
    }
}

/**
 * 双向链表方式
 */
class MyCircularDeque {

    LinkedList head;//头结点
    LinkedList tail;//尾节点
    int count;//总节点数
    int capcity;//总容量

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        count = 0;
        capcity = k;
        head = new LinkedList(-1);
        tail = new LinkedList(-1);
        head.prev = tail;
        tail.next = head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }else{
            LinkedList node = new LinkedList(value);
            head.prev.next = node;
            node.prev = head.prev;
            head.prev = node;
            node.next = head;
            count ++;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }else{
            LinkedList node = new LinkedList(value);
            tail.next.prev = node;
            node.next = tail.next;
            node.prev = tail;
            tail.next = node;
            count ++;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }else{
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
            count --;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }else{
            tail.next.next.prev = tail;
            tail.next = tail.next.next;
            count --;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }else{
            return head.prev.value;
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }else{
            return tail.next.value;
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == capcity;
    }

    /* 双向链表 */
    public class LinkedList
    {
        LinkedList prev;//指向前一个节点的指针
        LinkedList next;//指向后一个节点的指针
        int value;//值

        public LinkedList(int value){
            this.value = value;
            prev = null;
            next = null;
        }
    }
}