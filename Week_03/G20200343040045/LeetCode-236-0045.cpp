#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/**
 * 题目:二叉树的最近公共祖先
 * Solution: 递归解法：递归左右子节点，找到匹配的节点并返回（当找到2个与输入一直的节点即可返回其祖先节点）
 *           时间复杂度为O(n)（每个节点都只需要访问一遍）, 空间复杂度为O(n)(调用栈空间)
 * Test Cases:[],[3,5,1,6,2,0,8,null,null,7,4] 5 1 ,其他正常的案例
*/
class Solution {
   public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == p || root == q || root == NULL) return root;
        TreeNode* left  = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        if (left != NULL && right != NULL) {
            // 说明找到最近公共祖先
            return root;
        } else if (left == NULL && right != NULL) {
            return right;
        } else if (left != NULL && right == NULL) {
            return left;
        } else {
            return NULL;
        }
    }
};
