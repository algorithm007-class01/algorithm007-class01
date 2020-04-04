/*
* Summary:n-ary-tree-preorder-traversal
* Parameters:
*   root: tree-node
* Return: traversal vector
*/
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<int> res;
    vector<int> preorder(Node* root) {
		//recursion
        if (nullptr == root) {
            return res;
        }

        res.push_back(root->val);

        for (Node* node : root->children) {
            preorder(node);
        }

        return res;
		/* not-recursion
        vector<int> res;        
        if (NULL == root) {
            return res;
        }
        stack<Node*> st;
        st.push(root);
        
        while (!st.empty()) {
            Node *current = st.top();
            st.pop();
            res.push_back(current->val);
            for (int i = current->children.size() - 1; i >= 0; --i) {
                if (current->children[i] != nullptr) {
                    st.push(current->children[i]);
                }
            }
        }
        return res;		
		*/
    }
};