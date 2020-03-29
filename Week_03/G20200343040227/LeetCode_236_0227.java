package week3.homework;

public class LeetCode_236_0227 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当遍历到叶结点后就会返回null
        if (root == null) return root;
        //当找到p或者q的是时候就会返回pq
        /*当然，值得一提的是，如果公共祖先是自己（pq），
        并不需要寻找另外 一个，我们在执行前序遍历会先找上面的，后找下面的，我们会直接返回公共祖先。*/
        if (root == p || root == q) return root;
        //返回的结点进行保存，可能是null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //也可能是pq，还可能是公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            //如果左右都存在，就说明pq都出现了，这就是，公共祖先，此时不用考虑公共祖先是自己的情况，因为上面已经做过判断了。
            return root;
        } else if (left != null) {//否则我们返回已经找到的那个值（存储在left，与right中），p或者q
            return left;//还有一种可能就是，由下面返回的公共祖先，并将这个值一路返回到最表层
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
