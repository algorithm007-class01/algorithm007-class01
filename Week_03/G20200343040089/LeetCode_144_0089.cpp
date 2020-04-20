/**
* Summary:binary-tree-preorder-traversal
* Parameters:
*   root: tree-node
* Return: traversal vector
*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> res;
    vector<int> preorderTraversal(TreeNode* root) {
		//recursion
        if (nullptr == root) {
            return res;
        }
        res.push_back(root->val);
        preorderTraversal(root->left);
        preorderTraversal(root->right);

        return res;
		//Mirros Traversal
		/*
        vector<int> res;
        TreeNode *current = root, *prev = NULL;
        while (current != NULL) {
            if (current->left == NULL) {
                res.push_back(current->val);
                current = current->right;
            } else {
                prev = current->left;
                while (prev->right != NULL && prev->right != current) {
                    prev = prev->right;
                }

                if (prev->right == NULL) {
                    res.push_back(current->val);
                    prev->right = current;
                    current = current->left;
                } else {
                    prev->right = NULL;
                    current = current->right;
                }
            }
        }
        return res;		
		*/
    }
};

