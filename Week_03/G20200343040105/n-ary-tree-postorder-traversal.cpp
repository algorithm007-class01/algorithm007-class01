//590. N叉树的后序遍历

//方法1：递归遍历搜索
class Solution {
public:
    vector<int> res;
    vector<int> postorder(Node* root) {
        _postorder(root);
        return res;    
    }
    void _postorder(Node* temp) {
        if (temp){ 
            for (int i = 0; i < temp->children.size(); ++i)
                _postorder(temp->children[i]);
            res.push_back(temp->val);
        }
    }
};

//方法2：使用栈来迭代，根-左-右 --> 左-右-根 ，前序遍历后转置为后序遍历
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> res;
        stack<Node*> st;
        if (root == NULL) return res;
        st.push(root);
        while(!st.empty()) {
            Node* temp = st.top();
            st.pop();
            for(int i = 0;i < temp->children.size(); i++) st.push(temp->children[i]);
            res.push_back(temp->val);
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
