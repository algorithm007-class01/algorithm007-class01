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
    vector<vector<int>> res;
    vector<vector<int>> levelOrder(Node* root) {
        levelOrder(root,0);
        return res;
    }
    void levelOrder(Node* node, int level){
        if(node == NULL){
            return;
        }
        if (res.size() == level) res.resize(level +1);
        res[level].push_back(node->val);
        auto childs = node->children;
        for(auto child:childs){
            levelOrder(child,level+1);
        }
    }
};