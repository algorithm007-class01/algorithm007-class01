//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列


package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;

public class DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque mydq = new DesignCircularDeque().new MyCircularDeque(3);
        mydq.insertFront(3);
        mydq.insertFront(2);
       mydq.deleteLast();
       mydq.deleteLast();
       mydq.deleteLast();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */

        int capacity=0;
        int size=0;
        Node<Integer> first;
        Node<Integer> last;





        public MyCircularDeque(int k) {
            capacity=k;

        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if(size>=capacity){
                return false;
            }else{
                Node<Integer>newNode=new Node<>(null,value,first);
                if(first==null){
                    first=newNode;
                    last=newNode;
                }else{
                    first.pre=newNode;
                    newNode.next=first;
                    first=newNode;
                }


                size++;
                return true;

            }

        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if(size>=capacity){
                return false;
            }else{
                Node node=new Node(last,value,null);
                if(last==null){
                    last=node;
                    first=node;
                }else{
                    last.next=node;
                    node.pre=last;
                    last=node;
                }
                size++;
                return true;
            }
        }



        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if(size==0)return false;
            else if(size==1){
                first=null;
                last=null;
                size--;
                return true;
            }
            else{

                    first=first.next;
                    first.pre=null;


                size--;
                return true;
            }

        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if(size==0)return false;
            else if(size==1){
                last=null;
                first=null;
                size--;
                return true;
            }
            else{

                    last=last.pre;
                    last.next=null;

                size--;
                return true;
            }
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if(first==null)return -1;
            else return first.data;

        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if(last==null)return -1;
            else return last.data;

        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            if(size==0)return true;
            else return false;

        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            if(size==capacity)return true;
            else return false;


        }

        class Node<E>{
            E data;
            Node<E> pre;
            Node<E> next;
            public Node(Node<E> pre,E e,Node<E> next){
                data=e;
                this.pre=pre;
                this.next=next;
            }

        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}