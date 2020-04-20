/*
 * @lc app=leetcode.cn id=144 lang=swift
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
 
class Solution {
    func preorderTraversal(_ root: TreeNode?) -> [Int] {
        var ans = [Int]()
        var stack = [TreeNode?]()
        var tree = root
        while tree != nil || !stack.isEmpty {
            while tree != nil {
                ans.append(tree!.val)
                stack.append(tree)
                tree = tree?.left
            }
            tree = stack.removeLast()
            tree = tree?.right
        }
        return ans
    }
}

public List<Integer> preorderTraversal(TreeNode node) {
    List<Integer> list = new LinkedList<Integer>();
    Stack<TreeNode> rights = new Stack<TreeNode>();
    while(node != null) {
        list.add(node.val);
        if (node.right != null) {
            rights.push(node.right);
        }
        node = node.left;
        if (node == null && !rights.isEmpty()) {
            node = rights.pop();
        }
    }
    return list;
}


public List<Integer> preorderIt(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if(root==null) return pre;
        Stack<TreeNode> tovisit = new Stack<TreeNode>();
        tovisit.push(root);
        while(!tovisit.empty()) {
            TreeNode visiting = tovisit.pop();
            pre.add(visiting.val);
            if(visiting.right!=null) tovisit.push(visiting.right);
            if(visiting.left!=null) tovisit.push(visiting.left);
        }
        return pre;
    }
}


Swift 究极递归解法 
func preorderTraversal(_ root: TreeNode?) -> [Int] {
        guard root != nil else { return [] }        
        return [root!.val] + preorderTraversal(root!.left) + preorderTraversal(root!.right)
}
// @lc code=end



