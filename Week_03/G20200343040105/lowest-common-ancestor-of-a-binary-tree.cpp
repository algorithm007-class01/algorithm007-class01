//236. 二叉树的最近公共祖先

//思路：递归
/**如果p，q都存在，则返回它们的公共祖先；
  *如果p，q只存在一个，则返回存在的一个；
  *如果p，q都不存在，则返回NULL
  */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL) return NULL;
        if (root == p || root == q) return root;
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        if (left == NULL) return right;
        if (right == NULL) return left;
        if (left && right) return root;
        return NULL;
    }
};
//时间复杂度：O(n) 空间复杂度：O(n)