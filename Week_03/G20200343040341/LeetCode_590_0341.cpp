class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> res;
        if(root==NULL) return res;

        stack<Node*> myStack;        
        myStack.push(root);

        Node* temp;
        
        while(!myStack.empty()) {
            temp=myStack.top();
            myStack.pop();
            res.push_back(temp->val);
            int width=temp->children.size();
            for(int i=0; i<width; i++) {
                myStack.push(temp->children[i]);
            }
        }
        reverse(res.begin(),res.end());
        return res;
    }
};