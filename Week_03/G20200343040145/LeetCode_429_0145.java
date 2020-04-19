import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层级遍历
 * */
public class LeetCode_429_0145 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            executeIterator(root,0,res);
        }
        return res;
    }

    public void executeIterator(Node node, int level, List<List<Integer>> res) {
        if (res.size() <= level) {
            // 第一进入该方法，level = 0
            // 之后每一次进入都是由上一个等级的节点调用
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        for (Node chNode : node.children) {
            executeIterator(chNode,level+1,res);
        }
    }
}
