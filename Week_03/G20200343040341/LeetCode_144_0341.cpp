class Solution {
public:
    vector<int> v;
    vector<int> preorderTraversal(TreeNode* root) {
        if(root){
            v.push_back(root->val);
            if(root->left){
                preorderTraversal(root->left);
            }
            if(root->right){
                preorderTraversal(root->right);
            }
        }
        return v;    
    }
};