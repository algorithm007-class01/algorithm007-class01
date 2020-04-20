package Week_03.G20200343040179;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mufan
 * @date 2020/3/29
 */
public class LeetCode_144_0179 {
    /**
     * 递归
     * 二叉树的前序遍历
     * 前序遍历：根-->左-->右
     */
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        //terminator
        if (root == null) {
            return list;
        }
        //process
        list.add(root.val);
        //dill down
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    /**
     * 迭代
     * 为什么迭代使用栈？因为递归的过程相当于就是压栈和出栈的过程,我们相当于在模拟入栈和出栈的过程
     * 1.使用迭代法解决,从上往下,首先将左子树压栈,并记录左子树
     * 2.当左子树出栈的时候,说明左子树已经遍历完了,然后取出栈顶元素,然后将栈顶元素的右子树,这时候需要判断右子树是否为空,如果为空则取出下一个栈顶元素
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return res;
    }
}
