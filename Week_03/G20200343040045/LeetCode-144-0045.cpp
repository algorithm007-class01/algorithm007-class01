#include <iostream>
#include <stack>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/**
 * 题目:二叉树的前序遍历
 * Solution1: 递归解法：借助辅助函数或者全局变量存放遍历结果
 *           先序遍历为：中->左->右
 *           时间复杂度为O(n), 空间复杂度为O(n)
 * Solution2:迭代法：借用stack进行记录
 *           时间复杂度为O(n)，空间复杂度为O(n)
 * Test Cases:[],[1,null,2,3],其他正常的案例
*/
class Solution {
   public:
   /**
    * 解法1：使用helper函数进行递归
   */
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> res;
        helper(root, res);
        return res;
    }
    void helper(TreeNode *root, vector<int> &res) {
        if (root != NULL) {
            res.push_back(root->val);
            helper(root->left, res);
            helper(root->right, res);
        }
    }
    /**
     * 解法2：使用栈记录节点
    */
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> res;
        if (root == NULL) return res;
        stack<TreeNode *> st;
        TreeNode *p = root;
        while (p != NULL || !st.empty()) {
            if (p != NULL) {
                res.push_back(p->val);
                if (p->right != NULL) {
                    st.push(p->right);
                }
                p = p->left;
            } else {
                p = st.top();
                st.pop();
            }
        }
        return res;
    }
};
