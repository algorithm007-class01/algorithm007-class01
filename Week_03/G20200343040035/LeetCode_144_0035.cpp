#include<vector>
#include<stack>
using namespace std;
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root ==  NULL){
            return res;
        }
        res.push_back(root->val);
        if (root->left)
            preorderTraversal(root->left);
        if (root->right) 
        preorderTraversal(root->right);
        return res;
    }
};


class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode *> s;
        TreeNode* node = root;
        s.push(node);
        while (node || !s.empty()){
            while(node){
                res.push_back(node->val);
                s.push(node->right);
                node = node->left;
            }
            node = s.top();
            s.pop();
        }
        return res;
    }
};