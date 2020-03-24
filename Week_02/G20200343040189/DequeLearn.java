import java.util.Deque;
import java.util.LinkedList;

public class DequeLearn {
    public static void main(String[] args){
        // LinkedList实现Deque接口的方法
        Deque<String> deque = new LinkedList<>();
        // 从队列头部插入数据
        deque.addFirst("c");
        deque.addFirst("b");
        deque.addFirst("a");
        // 从队列尾部插入数据
        deque.addLast("f");
        deque.addLast("e");
        deque.addLast("d");
        System.out.println(deque);
    }
}