import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * n 叉树前序遍历
 * */
public class LeetCode_589_0145 {

    /**
     *  迭代的方法
     *  取值顺序：根 -> 左 -> 右
     *  590题目中的顺序是 左右根
     * */
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node last = stack.pollLast();
            res.add(last.val);
            // 这里进行了反转
            //
            // 不进行
            /* 这里进行了反转，用LinkedList来模拟栈的效果
            *   正常情况下 左节点先入栈，后出栈，左节点的子节点也是如此
            *   反转后，左节点后入栈
            * */
            Collections.reverse(last.children);
            for (Node ch : last.children) {
                stack.add(ch);
            }
        }
        return res;
    }
}
