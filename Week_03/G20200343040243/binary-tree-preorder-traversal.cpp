#include<vector>
#include<iostream>

using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        if(root == nullptr)
            return {};

        vector<int> res;
        _preorderTraversal(root, res);

        return res;
    }

    void _preorderTraversal(TreeNode* n, vector<int>& res) {
        // terminator
        if(n == nullptr)
            return;

        // merge subresult
        res.push_back(n->val);

        // split subproblem and drill down
        _preorderTraversal(n->left, res);
        _preorderTraversal(n->right, res);

        // reverse status
    }
};

int main() {

    return 0;
}