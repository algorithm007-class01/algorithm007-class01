#include<vector>
#include<stack>
using namespace std;
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

class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> res;
        postorder(root,res);
        return res;
    }
    void postorder(Node* node, vector<int> &res){
        if (node == NULL){
            return;
        }
        for (auto child:node->children){
            postorder(child, res);
        }
        res.push_back(node->val);
    }
};