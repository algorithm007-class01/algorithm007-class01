#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
	// core code
	TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
		if (inorder.empty()) {
		}

		int pos = 0;
		return buildTreeImpl(preorder, pos, inorder, 0, inorder.size() - 1);
	}

private:
	TreeNode* buildTreeImpl(vector<int>& preorder, int& pos, vector<int>& inorder, int left, int right) {
		if (pos >= preorder.size()) {
			return nullptr;
		}

		int i = left;
		for (i = left; i <= right; ++i) {
			if (inorder[i] == preorder[pos]) break;
		}
		TreeNode* node = new TreeNode(preorder[pos]);
		if (left <= i - 1) node->left = buildTreeImpl(preorder, ++pos, inorder, left, i - 1);  // 左子树
		if (i + 1 <= right) node->right = buildTreeImpl(preorder, ++pos, inorder, i + 1, right);  // 右子树
		return node;
	}
};


void printPreOrder(const TreeNode* node) {
	if (!node) {
		cout << "null";
		return;
	}
	cout << node->val << "->";
	printPreOrder(node->left);
	printPreOrder(node->right);
}

void test_case() {
	// tested on the leetcode
	Solution sul;
	vector<int> preorder = { 3,9,20,15,7 };
	vector<int> indorder = { 9,3,15,20,7 };

	printPreOrder(sul.buildTree(preorder, indorder));
}

int main(int argc, char* argv) {
	test_case();
	return 0;
}