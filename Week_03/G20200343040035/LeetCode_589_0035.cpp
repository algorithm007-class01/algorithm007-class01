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
    vector<int> preorder(Node* root) {
        vector<int> res;
        preorder(root, res);
        return res;
    }
    void preorder(Node* node, vector<int> &res){
        if (node == NULL){
            return;
        }
        res.push_back(node->val);
        for(auto child:node->children){
            preorder(child,res);
        }
        
    }
};