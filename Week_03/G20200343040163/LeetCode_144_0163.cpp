// 迭代
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> todo;
        while (root || !todo.empty()) {
            while (root) {
                todo.push(root -> right);
                res.push_back(root -> val);
                root = root -> left;
            }
            root = todo.top(); todo.pop();
        }
        return res;
    }
};

// 递归
class Solution {
public:
    vector<int> res;
    vector<int> preorderTraversal(TreeNode* root) {
        if (root == nullptr) return res;
        res.push_back(root -> val);
        if (root -> left) preorderTraversal(root -> left);
        if (root -> right) preorderTraversal(root -> right);
        return res;
    }
};