package G20200343040039
// TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
// if(root == NULL)
// return NULL;
// if(root == p || root == q)
// return root;
//
// TreeNode* left =  lowestCommonAncestor(root->left, p, q);
// TreeNode* right = lowestCommonAncestor(root->right, p, q);
//
// if(left == NULL)
// return right;
// if(right == NULL)
// return left;
// if(left && right) // p和q在两侧
// return root;
//
// return NULL; // 必须有返回值
// }
// };

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		 return nil
	}

	if root == p || root == q {
		return root
	}

	left := lowestCommonAncestor(root.Left, p, q);
	right := lowestCommonAncestor(root.Right, p, q)

	if left == nil {
		 return right
	}

	if right == nil {
		 return left
	}

	if left != nil && right != nil {
		return root
	}

	return nil
}