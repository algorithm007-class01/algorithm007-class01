package myself;

import java.util.Stack;

public class LeetCode_236_0201 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 因为要找出共同祖先节点，所以会有遍历的过程。
         * 那么过程当中，那必须是要把遍历过的根节点存放起来，
         * 因为如果p和q如果没有父子关系，祖先节点是会在这些节点中产生的，所以得找个容器存起来。
         */
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr == null) {
                curr = stack.pop().right;
                continue;
            }
            /**
             * 将根节点入栈，然后一直沿树探寻下去。
             * 直到找到p，q其中一个节点。
             */
            if (curr.val != p.val && curr.val != q.val) {
                stack.push(curr);
                curr = curr.left;
                continue;
            } else {
                break;
            }
        }

        /**
         * =======================
         * 既然上面找到了p或者q节点，那么祖先节点只有两种情况了。
         * 1. 要不就是目前的p或者q
         * 2. 要不就是栈中之前存放的某一节点，就是共同祖先节点
         * 所以，下面的代码就是探寻这两种情况
         */

        if (curr.val == p.val) {
            if (checkContains(curr, q))
                return p;
            else
               return findFromStack(stack, q);
        }
        if (curr.val == q.val) {
            if (checkContains(curr, p))
                return q;
            else
                return findFromStack(stack, p);
        }
        return null;
    }

    /**
     * 从栈中找出，含有目标节点的子树的 根节点
     */
    private TreeNode findFromStack(Stack<TreeNode> stack, TreeNode target) {
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (checkContains(top.right, target))
                return top;
        }
        return null;
    }

    /**
     * 用来检查，树root内是否含有target节点
     */
    private boolean checkContains(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val)
            return true;
        else
            return checkContains(root.left, target) || checkContains(root.right, target);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
