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
    //迭代 bfs
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<Integer>(size);
            for(int i = 0;i < size;i ++){
                TreeNode node = q.poll();
                row.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            ans.add(row);
        }
        return ans;
    }
//    递归 dfs 比较反常识
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
//        if(root == null){
//            return ans;
//        }
//
//        levelOrder(ans,root,0);
//        return ans;
//    }
//    private void levelOrder(ArrayList<List<Integer>> ans,TreeNode root,int level){
//        if(ans.size() == level){
//            ans.add(new ArrayList());
//        }
//        ans.get(level).add(root.val);
//        if(root.left != null){
//            levelOrder(ans,root.left,level + 1);
//        }
//        if(root.right != null){
//            levelOrder(ans,root.right,level + 1);
//        }
//    }
}