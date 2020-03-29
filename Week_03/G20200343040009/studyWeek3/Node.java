import java.util.List;

public class Node {
    public int val;
    public List<com.studyWeek3.Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<com.studyWeek3.Node> _children) {
        val = _val;
        children = _children;
    }
}