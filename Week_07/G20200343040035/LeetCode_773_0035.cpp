struct tree{
    bool is_node;
    int val;
    tree* children[6];
    tree(int value,bool flag){val=value;is_node=flag;for(int i=0;i<6;i++)children[i]=NULL;}
};
class Solution {
public:
    //广度优先搜索，使用字典树来记录状态
    tree *T=new tree(-1,false);
    bool find_insert(vector<vector<int>> board,int flag){//flag判断是否需要执行插入操作
        vector<int> res;
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++)res.push_back(board[i][j]);
        }
        tree *t=T;int now=0;
        while(now<6&&t->children[res[now]]!=NULL){
            t=t->children[res[now]];now++;
        }
        //找到了就不插入并返回true
        if(now==6){
            return true;
        }
        //找不到则插入并返回false
        if(flag){
            tree *p;
            while(now<6){
                p=new tree(res[now],false);
                t->children[res[now]]=p;
                t=p;now++;
            }
            t->is_node=true;
        }
        return false;
    }
    vector<int> findzero(vector<vector<int>> board){
        vector<int> res;
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                if(!board[i][j]){
                    res.push_back(i);
                    res.push_back(j);
                }
            }
        }
        return res;
    }
    int slidingPuzzle(vector<vector<int>>& board) {
        int step=0,c=1;
        vector<vector<int>> final_board;
        vector<int> r;
        r.push_back(1);r.push_back(2);r.push_back(3);
        final_board.push_back(r);r.clear();
        r.push_back(4);r.push_back(5);r.push_back(0);
        final_board.push_back(r);
        //初始化字典树
        find_insert(board,true);
        queue<vector<vector<int>>> in_queue;
        queue<vector<int>> zero_queue;
        zero_queue.push(findzero(board));
        in_queue.push(board);
        while(!in_queue.empty()){//广度优先搜索
           if(find_insert(final_board,false))return step;
           int s=in_queue.size();
           for(int i=0;i<s;i++){
               vector<vector<int>> now_board=in_queue.front();
               in_queue.pop();
               vector<int> posi=zero_queue.front();
               zero_queue.pop();
               //将邻居节点加入
               int mid,row=posi[0],line=posi[1];
               vector<vector<int>> row_board=now_board;
               //上下交换
               vector<int>change,zero;
               change.push_back((row==0)? 1:0);
               row_board[row][line]=now_board[change[0]][line];
               row_board[change[0]][line]=now_board[row][line];
               if(!find_insert(row_board,true)){
                   zero.clear();
                   zero.push_back(change[0]);
                   zero.push_back(line);
                   zero_queue.push(zero);
                   in_queue.push(row_board);
               }
               //左右交换
               change.clear();
               if(line==1){
                   change.push_back(0);change.push_back(2);
                }
               else change.push_back(1);
               for(auto c:change){
                   vector<vector<int>> line_board=now_board;
                   line_board[row][c]=now_board[row][line];
                   line_board[row][line]=now_board[row][c];
                   if(!find_insert(line_board,true)){
                       in_queue.push(line_board);
                       zero.clear();
                       zero.push_back(row);
                       zero.push_back(c);
                       zero_queue.push(zero);
                   }
               }
           }
           step++;
        }
        return -1;
    }
};