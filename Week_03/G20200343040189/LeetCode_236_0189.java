//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 解法1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 中序遍历判断两个结点是否都在左子树
        TreeNode cur = root.left;
        boolean pLeft = false;
        boolean qLeft = false;
        while (cur != null || !stack.isEmpty()) {
            // 结点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 结点为空就出栈
            cur = stack.pop();
            // 判断是否等于p结点
            if (cur == p) {
                pLeft = true;
            }
            // 判断是否等于q结点
            if (cur == q) {
                qLeft = true;
            }
            if (pLeft && qLeft) {
                break;
            }
            // 考虑右子树
            cur = cur.right;
        }
        // 全在左子树
        if (pLeft && qLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 全在右子树
        else if (!pLeft && !qLeft) {
            return  lowestCommonAncestor(root.right, p, q);
        }
        // 分散在两边
        return root;
    }

    // 解法2
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        // 在左子树递归查找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left != null && p != left && q != left) {
            return left;
        }
        // 在右子树递归查找
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null && p != right && q != right) {
            return right;
        }
        // 分在左右两棵子树中，则返回root
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
