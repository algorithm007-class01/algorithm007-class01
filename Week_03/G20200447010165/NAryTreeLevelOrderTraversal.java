//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索

  
package com.dxm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
///*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
//*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res =  new ArrayList<>();
        if( root == null) return res;
        recursion(0, res, root);
        return res;
    }

    private void recursion(int level, List<List<Integer>> res, Node node) {
        if (node == null) return;
        if (level+1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        for (Node child : node.children) {
           if (child != null) recursion(level+1, res, child);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}