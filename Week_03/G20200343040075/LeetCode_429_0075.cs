/*
 * @lc app=leetcode.cn id=429 lang=csharp
 *
 * [429] N叉树的层序遍历
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
using System;
using System.Collections.Generic;

public class Solution {
    /// <summary>
    /// BFS
    /// </summary>
    /// <param name="root"></param>
    /// <returns></returns>
    public IList<IList<int>> LevelOrder (Node root) {
        List<IList<int>> res = new List<IList<int>> ();
        if (root != null) {
            Queue<Node> queue = new Queue<Node> ();
            queue.Enqueue (root);
            int size = 1;
            while (queue.Count > 0) {
                IList<int> resList = new List<int> ();
                for (int i = 0; i < size; i++) {
                    Node curNode = queue.Dequeue ();
                    resList.Add (curNode.val);
                    foreach (var node in curNode.children) {
                        queue.Enqueue (node);
                    }
                }
                size = queue.Count;
                res.Add (resList);
            }
        }
        return res;
    }
}
// @lc code=end