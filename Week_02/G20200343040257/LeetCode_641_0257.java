package cxl.study.leetcode;

/**
 * 641. 设计循环双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 */
public class LeetCode_641_DesignCircularDeque {

    public static class MyCircularDeque {

        private int size;

        private int temp = 0;

        private Node queueData;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.size = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (temp == size) return false;
            if (queueData == null) {
                queueData = new Node(value, null);
            } else {
                Node tempNode = queueData;
                Node firstNode = new Node(value, queueData);
                firstNode.next = tempNode;
                queueData = firstNode;
            }
            temp++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (temp == size) return false;
            if (getLastNode() == null) {
                queueData = new Node(value, null);
            } else {
                Node lastNode = getLastNode();
                lastNode.next = new Node(value, null);
            }
            temp++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (queueData == null) {
                return false;
            } else {
                queueData = queueData.next;
            }
            temp--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            int i = 0;
            Node prev = null;
            Node tempNode = queueData;
            if (tempNode == null) return false;
            if (temp == 1) {
                queueData = null;
                temp--;
                return true;
            } else {
                while (i < temp) {
                    prev = tempNode;
                    tempNode = tempNode.next;
                    i++;
                    if (tempNode.next == null) {
                        prev.next = null;
                        temp--;
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (queueData == null) {
                return -1;
            }
            return queueData.val;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (getLastNode() == null) {
                return -1;
            }
            return getLastNode().val;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return queueData == null;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return temp == size;
        }

        private Node getLastNode() {
            int i = 0;
            Node tempNode = queueData;
            if (tempNode == null) return null;
            while (i < temp) {
                if (tempNode.next == null) {
                    return tempNode;
                }
                tempNode = tempNode.next;
                i++;
            }
            return null;
        }

        private static class Node {
            int val;
            Node next;

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }

            public int getVal() {
                return val;
            }

            public void setVal(int val) {
                this.val = val;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }


}
