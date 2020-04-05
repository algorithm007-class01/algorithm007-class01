  class Solution {
    /**
     * 二叉树的前序遍历：根-左-右
     *
     * 【递归遍历】
     *
     * 时间复杂度：O(n) 递归 T(n) = 2*T(n/2) + 1
     * 空间复杂度：最坏情况为O(n)，平均情况为O(logn)
     *
     * **/

    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<Integer>();
      preOrder(root, result);
      return result;
    }

    public void preOrder(TreeNode root, List<Integer> result){
      if (null != root){
        result.add(root.val);
        if(root.left != null) preOrder(root.left,result);
        if(root.right != null) preOrder(root.right,result);
      }
    }

  }