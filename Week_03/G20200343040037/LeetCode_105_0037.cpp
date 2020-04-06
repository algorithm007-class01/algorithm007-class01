class Solution{
	public:
		TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder){
			return buildTree(preorder, 0, inorder, 0, inorder.size() - 1);
		}

		TreeNode* buildTree(vector<int>& preorder, int pos, vector<int>& inorder, int left, int right){
			if(pos >= preorder.size() || left > right){
				return NULL;
			}
			// 找到根节点在inorder中的位置
			int i = left;
			for(; i <= right;i++){
				if(inorder[i] == preorder[pos]){
					break;
				}
			}
			// 先构建结构树的根节点, i节点代表根节点
			TreeNode* node = new TreeNode[preorder[pos]];
			// 按照根节点剖开inorder,left ~ i - 1是左子树
			if(left <= i - 1){
				node->left = buildTree(preorder, pos + 1, inorder, left, i - 1);
			}
			// 按照根节点剖开 i + 1 ~ right是右子树, 
			if(i + 1 <= right){
				node->right = buildTree(preorder, pos + i - left + 1, inorder, i + 1, right);
			}
			return node;
		}
};
