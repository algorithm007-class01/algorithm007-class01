import java.util.Deque;
import java.util.LinkedList;

public class Deque_Demo_Enhance_via_AddLast {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();

        deque.addLast("c");
        deque.addLast("a");
        deque.addLast("b");

        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }

        System.out.println(deque);
    }

}
