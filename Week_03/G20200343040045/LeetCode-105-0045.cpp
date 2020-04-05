#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/**
 * 题目:从前序和中序遍历构造二叉树
 * Solution: 递归解法：
 *           时间复杂度为O(n)，空间复杂度为O(n)
 * Test Cases:[],特殊二叉树（所有节点都没有右子节点的二叉树）
*/
class Solution {
   public:
    /**
    * 解法1：使用helper函数进行递归
    * 通过前序遍历确定跟节点，再使用此节点将中序遍历进行分割
   */
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        return helper(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1);
    }
    /**
     * preorder表示前序遍历序列
     * inorder表示中序遍历序列
     * ps表示preorder起点下标
     * pe表示preorder末尾下标
     * is表示inorder起点下标
     * ie表示inorder末尾下标
    */
    TreeNode *helper(vector<int> &preorder, vector<int> &inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return nullptr;
        }
        TreeNode *node = new TreeNode(preorder[ps]);
        int pos;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == node->val) {
                pos = i;
                break;
            }
        }
        node->left  = helper(preorder, inorder, ps + 1, ps + pos - is, is, pos - 1);
        node->right = helper(preorder, inorder, pe - ie + pos + 1, pe, pos + 1, ie);
        return node;
    }
};
