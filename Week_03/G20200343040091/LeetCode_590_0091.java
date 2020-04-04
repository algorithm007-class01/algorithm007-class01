class Solution {

    /**
     * 590. N叉树的后序遍历
     * 【递归求解】
     **/

    private List<Integer> res;

    public List<Integer> postorder(Node root) {
      res = new LinkedList<>();
      dfs(root);
      return res;
    }

    private void dfs(Node root) {
      if (root == null) {
        return;
      }
      for (Node child : root.children) {
        dfs(child);
      }
      res.add(root.val);
    }

  }