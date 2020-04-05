import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {

    public static void main(String[] args) {

        Deque deque = new LinkedList();
        //链表头部插入
        deque.addFirst(1);
        deque.addFirst(2);
        //链表尾部插入
        deque.addLast(3);
        System.out.println(deque);
        //弹出链表头部
        System.out.println(deque.pollFirst());
        System.out.println(deque);
        //弹出链表尾部
        System.out.println(deque.pollLast());
    }
}
