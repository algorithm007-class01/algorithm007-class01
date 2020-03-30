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
 * 题目：N叉树的层序遍历
 * Solution: 递归法：使用辅助函数或者全局变量存放遍历结果
 *           时间复杂度为O(n) 空间复杂度为O(n)
 * test Cases:空树[],[1,null,3,2,4,null.5,6]
*/

class Solution {
   public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        helper(root, res, 0);
        return res;
    }
    void helper(Node* root, vector<vector<int>>& res, int layer) {
        if (root != NULL) {
            // vector 增加长度
            if (layer == res.size()) res.resize(layer + 1);
            res[layer].push_back(root->val);
            for (int i = 0; i < root->children.size(); i++)
                helper(root->children[i], res, layer + 1);
        }
    }
};