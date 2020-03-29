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
// public:
//         vector<int> inorderTraversal(TreeNode* root) {
//             vector<int> res;
//             if (root ==NULL)
//             {
//                 return res;
//             }
//             if (root->left)
//             {
//                 inorderTraversal(root->left);
//             }
//             res.push_back(root->val);
//             if (root->right)
//             {
//                 inorderTraversal(root->right);
//             }
//             return res;
//         }
// };

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode *> s;
        vector<int> res;
        TreeNode *node = root;
        while(node || !s.empty()){
            while(node){
                s.push(node);
                node = node->left;
            }
            node = s.top();
            res.push_back(node->val);
            s.pop();
            node = node->right;
        }
        return res;
    }
};