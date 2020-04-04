//589. N叉树的前序遍历

//方法1：递归遍历
class Solution {
public:
    vector<int>res;
    vector<int> preorder(Node* root) {
        _preorder(root);
        return res;
    }
    void _preorder(Node* temp){
        if(temp) {
            res.push_back(temp->val);
            for(int i = 0; i < temp->children.size(); ++i)
                _preorder(temp->children[i]);
        }
    }
};
//时间复杂度：O(n)  空间复杂度：O(n)

//方法2：迭代遍历
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> res;
        stack<Node*> st;
        if (root == NULL) return res;
        st.push(root);
        while (!st.empty()) {
            Node* temp = st.top();
            st.pop();
            for (int i = temp->children.size() - 1; i >= 0; --i) {
                st.push(temp->children[i]);
            }
            res.push_back(temp->val);
        }
        return res;
    }
};
时间复杂度：O(n)  空间复杂度：O(n)