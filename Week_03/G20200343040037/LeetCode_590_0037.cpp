class Solution {
public:
    vector<int> postorder(Node* root) {
	vector<int> result;
	if(NULL == root){
		return result;
	}
	// 第一种解法，递归
	//postorder(root, result);
	// 第二种解法，非递归+辅助栈
	stack<Node*> s;
	s.push(root);
	while(!s.empty()){
		Node* t = s.top();
		s.pop();
		result.insert(result.begin(), t->val);
		for(auto& i: t->children){
			s.push(i);// 将叶子节点压入到栈内。
		}
	}
	return result;
    }
    // 递归函数版本辅助函数。
    void postorder(Node* root, vector<int>* cur){
	if(NULL == root){
		return;
	}

	if(!root->children.empty()){
		for(auto& s: root->children){
			postorder(root, cur);
		}
	}

	cur.push_back(root->val);
    }
};
