/*
* Summary:n-ary-tree-postorder-traversal
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
    vector<int> postorder(Node* root) {
		// recursion
        if (nullptr == root) {
            return res;
        }
        
        for (Node* node : root->children) {
            postorder(node);
        }

        res.push_back(root->val);

        return res;
		/* not-recursion
        if (NULL == root) return {};
        vector<int> res;
        stack<Node*> st;
        st.push(root);
        while (!st.empty()) {
            Node *temp = st.top();
            st.pop();
            for (Node *node : temp->children) {
                st.push(node);
            }
            res.push_back(temp->val);
        }
        reverse(res.begin(), res.end());
        return res;		
		*/
    }
};