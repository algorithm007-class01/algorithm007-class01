/**
* 641. 设计循环双端队列<p>
*https://leetcode-cn.com/problems/design-circular-deque/
*@author tim@timloong.win
*/
class MyCircularDeque {
    private int[] array;
    private int index=-1;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        array=new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(index>=array.length-1){
            return false;
        }else{
            for(int i=index;i>=0;i--){
                array[i+1]=array[i];
            }
            array[0]=value;
            index++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(index>=array.length-1){
            return false;
        }else{
            index++;
            array[index]=value;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(index<0){
            return false;
        }else{
            for(int i=1;i<=index;i++){
                array[i-1]=array[i];
            }

            array[index]=0;

            index--;

            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(index<0){
            return false;
        }else{
            array[index]=0;
            index--;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(index<0){
            return -1;
        }else{
            return array[0];
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(index<0){
            return -1;
        }else{
            return array[index];
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return index<0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return index>=array.length-1;
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