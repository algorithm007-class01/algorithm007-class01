// 迭代
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> todo;
        while (root || !todo.empty()) {
            while (root) {
                todo.push(root);
                root = root -> left;
            }
            root = todo.top(); todo.pop();
            res.push_back(root -> val);
            root = root -> right;
        }
        return res;
    }
};

// 递归
class Solution {
public:
    vector<int> res;
    vector<int> inorderTraversal(TreeNode* root) {
        if (root == nullptr) return res;
        if (root -> left) inorderTraversal(root -> left);
        res.push_back(root -> val);
        if (root -> right) inorderTraversal(root -> right);
        return res;
    }
};