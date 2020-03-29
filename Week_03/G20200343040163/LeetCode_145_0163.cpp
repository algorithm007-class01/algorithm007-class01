// 迭代
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> todo;
        while (root != nullptr || !todo.empty()) {
            while (root) {
                todo.push(root -> left);
                res.push_back(root -> val);
                root = root -> right;
            }
            root = todo.top(); todo.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

// 递归
class Solution {
public:
    vector<int> res;
    vector<int> postorderTraversal(TreeNode* root) {
        if (root == nullptr) return res;
        if (root -> left) postorderTraversal(root -> left);
        if (root -> right) postorderTraversal(root -> right);
        res.push_back(root -> val);
        return res;
    }
};