class UnionFind{
private:
    vector<int> node; // 存放结点对应root
public:
    UnionFind(int n){ // 初始化点的数量
        node.resize(n);
        for(int i=0;i<n;i++) node[i] = i; //初始化每个结点都单独为一个集合
    }
    bool isConnect(int a,int b){ //判断a,b两点是否连通
        return find(a)==find(b);
    }
    int find(int a){//找到a点根
        // 查找的过程进行路径压缩
        int son = a; // 保存该点
        while(node[a]!=a) a = node[a]; //寻找到根
        // 再来一次进行路径压缩
        while(node[son]!=a){
            int temp = node[son]; // 保存上级结点
            node[son] = a;
            son = temp;
        }
        return a;
    }
    void nodeUnion(int a,int b){//连通a,b两点
        a = find(a);
        b = find(b);
        node[a] =  b; // 该步骤相当于将a所在树变为b所在树的一个子树。
    }
};
class Solution {
private:
    int dir[4][2] = {{1,0},{0,1},{-1,0},{0,-1},};
public:
    void solve(vector<vector<char>>& board) {
        int r = board.size();
        if(r<1) return;
        int c = board[0].size();
        UnionFind u(r*c+1); // 多加了一位，保留位，与其相连的点为非'X'围绕的'O'
        int dummy = r*c; //和该节点连通的'O'点是不需要变动的
        // 将'O'点分为两类
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='O'){
                    if(i==0||j==0||i==r-1||j==c-1){//边缘点
                        u.nodeUnion(i*c+j,dummy);
                    }
                    else{ //和上下左右的'O'进行连通
                        for(int k=0;k<4;k++){
                            int curr = i+dir[k][0];
                            int curc = j+dir[k][1];
                            if(curr>=0&&curr<r&&curc>=0&&curc<c&&board[curr][curc]=='O')
                                u.nodeUnion(i*c+j,curr*c+curc);
                        }
                    }
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='O'&&!u.isConnect(i*c+j,dummy)) board[i][j] = 'X';
            }
        }
    }
};