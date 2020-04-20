#include <iostream>
#include <vector>

using namespace std;

class Node {
   public:
    int val;
    vector<Node*> children;
    Node() {
    }
    Node(int _val) {
        val = _val;
    }
    Node(int _val, vector<Node*> _children) {
        val      = _val;
        children = _children;
    }
};

/**
 * 题目：N叉树的前序遍历
 * Solution: 递归法：使用辅助函数或者全局变量存放遍历结果
 *           时间复杂度为O(n) 空间复杂度为O(n)
 * test Cases:空树[],[1,null,3,2,4,null.5,6]
*/

class Solution {
   public:
    vector<int> preorder(Node* root) {
        vector<int> res;
        helper(root, res);
        return res;
    }
    void helper(Node* root, vector<int>& res) {
        if (root != NULL) {
            res.push_back(root->val);
            for (int i = 0; i < root->children.size(); i++)
                helper(root->children[i], res);
        }
    }
};