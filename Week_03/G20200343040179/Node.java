package Week_03.G20200343040179;

import java.util.List;

/**
 * @author mufan
 * @date 2020/3/28
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
