/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 
/**
* 144. 二叉树的前序遍历 <p>
* https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
*
*/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(null==root){
            return list;
        }else{
            list.add(root.val);
            if(root.left!=null){
                list.addAll(preorderTraversal(root.left));
            }
            if(root.right!=null){
                list.addAll(preorderTraversal(root.right));
            }
            return list;
        }
    }
}