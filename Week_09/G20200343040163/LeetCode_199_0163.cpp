class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        recursion(root, 1, res);
        return res;
    }

    void recursion(TreeNode* node, int depth, vector<int> &res) {
        if (node == NULL) return;
        if (res.size() < depth) res.push_back(node -> val);
        recursion(node -> right, depth + 1, res);
        recursion(node -> left, depth + 1, res);
    }
};
