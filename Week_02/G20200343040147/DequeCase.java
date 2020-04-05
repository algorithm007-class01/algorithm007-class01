import java.util.Deque;
import java.util.LinkedList;

public class DequeCase {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addFirst("b");
        //从队头压入
        deque.addFirst("c");
        //从队尾插入
        deque.addLast("d");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }
}
