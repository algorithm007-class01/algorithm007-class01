#include <vector>
#include <iostream>

using namespace std;

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
        if(root == nullptr)
            return {};

        vector<int> res;
        _postorder(root, res);  

        return res;  
    }

    void _postorder(Node* n, vector<int>& res) {
        // terminator
        if(n == nullptr)
            return;
        
        // prepare data, split big problem
        for(int i = 0; i < n->children.size(); ++i)
            // drill down, conquer subproblems
            _postorder(n->children[i], res);

        // merge subresult
        res.push_back(n->val);

        // reverse status

    }
};