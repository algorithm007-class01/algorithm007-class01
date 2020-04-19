class Solution {
	
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q){
		if(NULL == root || root == p || root == q){
			return root;
		}
		
		// 第一种解法 递归版本
		/*TreeNode* left = lowestCommonAncestor(root->left, p, q);
		TreeNode* right = lowestCommonAncestor(root->right, p, q);

		if(NULL == left){
			return right;
		}else if(NULL == right){
			return left;
		}else if(left && right){
			return root;
		}

		return NULL;*/

		// 第二种解法 迭代版本
		// pathp: 记录p节点的路径
		// pathq: 记录q节点的路径
		// temp : 保存当前节点的路径
		// last: 保存最后的节点
		//
		vector<TreeNode*> pathp, pathq, temp;
		TreeNode* cur = root;
		TreeNode* last = NULL;
		while(pathp.empty() || pathq.empty()){
			if(cur){
				temp.push_back(cur);
				if(temp.back() == p){ // 更新path p
					pathp = temp;
				}
				if(temp.back() == q){ // 更新path q
					pathq = temp;
				}
				cur = cur->left;// 更新左节点.

			}else{
				// 最后的元素是否有右节点，并且右节点是否等于最后节点
				if(temp.back()->right && temp.back()->right != last){
					cur = temp.back()->right;// 更新当前节点
				}else{
					last = temp.back();// 更新最后节点
					temp.pop_back();// 删除最后一个元素
				}
			}
		}
		// 取p,q路径最小值
		int size = min(pathp.size(), pathq.size());
		// 找到有不相等的节点，如果不相等的话，就是最小公共祖先
		for(int i = 0; i < size; i++){
			if(pathp[i] != pathq[i]){
				return pathp[i-1];
			}
		}
		// 如果没有的话，就返回最后一个.
		return pathp[size - 1];
}

};
