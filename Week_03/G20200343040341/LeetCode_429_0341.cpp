class Solution {
public:
    vector<vector<int>> res;
    
    void DFS(Node* root, int dep){
        //第一步：确定终结条件
        if(!root) return;
        if(dep==res.size()) res.emplace_back();
        //第二步：处理数据
        res[dep].push_back(root->val);
        //第三步：下探一层
        for(auto c : root->children){
            DFS(c, dep+1);
        }
    }

    vector<vector<int>> levelOrder(Node* root) {
        DFS(root,0);
        return res;
    }
};