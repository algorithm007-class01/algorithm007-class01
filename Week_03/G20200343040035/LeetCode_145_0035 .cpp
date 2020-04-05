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


// class Solution {
//     vector<int> res;
// public:
//     vector<int> postorderTraversal(TreeNode* root) {
//         if (root == NULL){
//             return res;
//         }
//         if(root->left) postorderTraversal(root->left);
//         if(root->right) postorderTraversal(root->right);
//         res.push_back(root->val);
//         return res;
//     }
// };


class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode *> s;
        TreeNode *node = root;
        s.push(node);
        while(node || !s.empty()){
            while(node){
                res.push_back(node->val);
                s.push(node->left);
                node = node->right;
            }
            node = s.top();
            s.pop();
        }
        return res;
    }
};