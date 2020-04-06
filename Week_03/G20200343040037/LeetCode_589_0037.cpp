class Solution{
	vector<int> preorder(Node* root){
		vector<int> result;
		if(NULL == root){
			return result;
		}
		//第一种解法,递归
		preorder(root, result);
		// 第二种解法，非递归
		stack<Node*> s;
		s.push(root);
		while(!s.empty()){
			Node* t = s.top();
			s.pop();
			result.push_back(t->val);
			if(!t->children.empty()){
				for(int i = t->children.size() - 1; i>= 0; i--){
					if(t->children[i]){
						s.push(t->children[i]);
					}

				}	

			}
		}
		return result;
	}
	void preorder(Node* root, vector<int>& cur){
		if(NULL == root){
			return;
		}
		cur.push_back(root->val);
		if(!root->children.empty()){
			for(auto& s:root->children){
				preorder(s, cur);
			}
		}
	}

};
