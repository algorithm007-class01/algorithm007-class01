package DailyPractice;

import Week_03.TreeNode;

public class LeetCode_236_0215 {
    private TreeNode ans=null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            recurseTree(root,p,q);
            return ans;
        }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
                   if (currentNode ==null){
                       return false;
                   }
                   int left = recurseTree(currentNode.left, p, q)?1:0;
                   int right = recurseTree(currentNode.right, p, q)?1:0;
                   int min  = (currentNode==p || currentNode==q)?1:0;
                   if (left+right+min>=2){
                       this.ans = currentNode;
                   }
                   return (left+right+min)>0;
    }
}

