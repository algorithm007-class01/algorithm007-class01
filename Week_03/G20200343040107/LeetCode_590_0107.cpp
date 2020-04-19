#include <iostream>
#include <vector>
#include <stack>
using namespace std; 

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
		if(!root) {
			return vector<int>();
		}
		stack<TreeNode*> tmp_stack;
		vector<int> res;
		TreeNode* cur_node = root;

		while(cur_node != NULL || !tmp_stack.empty()) {
			while(cur_node != NULL) {
				tmp_stack.push(cur_node);
				res.push_back(cur_node->val);
				cur_node = cur_node->left;
			}
			cur_node = tmp_stack.top();
			tmp_stack.pop();
			cur_node = cur_node->right;
		}

		return res;
    }
};

void test_case() {
	// tested on the leetcode
}

int main(int argc, char* argv) {
	test_case(); 
	return 0; 
}