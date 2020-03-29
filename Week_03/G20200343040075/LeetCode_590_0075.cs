/*
 * @lc app=leetcode.cn id=590 lang=csharp
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/
using System.Collections.Generic;

public class Solution {
    public IList<int> Postorder(Node root) {
        List<int> res = new List<int>();
        if (root != null)
        {
            foreach (var node in root.children)
            {
                res.AddRange(Postorder(node));
            }
            res.Add(root.val);
        }
        return res;
    }
}
// @lc code=end

