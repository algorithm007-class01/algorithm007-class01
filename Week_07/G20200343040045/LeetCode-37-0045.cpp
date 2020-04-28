#include <iostream>
#include <vector>
using namespace std;
class Solution {
   public:
    void solveSudoku(vector<vector<char>>& board) {
        vector<pair<int, int>> empty;  //用来保存所有未填入数字的位置
        empty.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')  //如果位置(i,j)未被填入数字
                {
                    empty.push_back(make_pair(i, j));  //添加位置(i,j)
                }
            }
        }
        theSolution(0, empty, board);  //调用函数
    }
    bool theSolution(int num, vector<pair<int, int>>& empty, vector<vector<char>>& board) {
        /*
            num的含义是第(num+1)个需要填入数字的位置
            empty包含所有未填入数字的位置
            board是棋盘本身
        */
        if (num == empty.size())  //如果所有的位置都填完，则返回true。算法已经结束，所有递归套用都返回true
            return true;
        bool wrong1 = false;  //第一个判断：填入的位置的横纵2个方向的所有元素是否与填入的元素冲突
        bool wrong2 = false;  //第一个判断：填入的位置在9*9的棋盘中的第几个3*3的子棋盘中的所有元素是否与填入元素冲突
        int block;
        for (int i = 1; i < 10; i++)  //要填入的数字，从1到10
        {
            wrong1                                     = false;
            char ppp                                   = i + '0';  //将数字转化为char类型
            board[empty[num].first][empty[num].second] = ppp;
            for (int j = 0; j < 9; j++)  //遍历填入的位置的横纵2个方向的所有元素
            {
                if (j != empty[num].first && board[j][empty[num].second] == ppp || j != empty[num].second && board[empty[num].first][j] == ppp)  //第一个判断出错
                {
                    wrong1 = true;  //第一个判断出错
                    break;
                }
            }
            if (!wrong1)  //如果第一个判断没错
            {
                block  = empty[num].first / 3 + empty[num].second / 3 * 3;  //填入的位置在9*9的棋盘中的第几个3*3的子棋盘
                wrong2 = false;
                for (int j = (block * 3) % 9; j < (block * 3) % 9 + 3; j++)  //遍历子棋盘内的元素
                {
                    for (int k = (block / 3) * 3; k < (block / 3) * 3 + 3; k++) {
                        if (j == empty[num].first && k == empty[num].second)  //跳过填入的位置
                            continue;
                        if (board[j][k] == ppp)  //第二个判断出错
                        {
                            wrong2 = true;  //第二个判断出错
                            break;
                        }
                    }
                    if (wrong2)
                        break;
                }
                if (!wrong2)  //如果第二个判断没错（两个判断都没错）
                {
                    if (theSolution(num + 1, empty, board))  //递归调用下一个未被填入的位置，如果返回false，则继续进行循环
                        return true;
                }
            }
        }
        board[empty[num].first][empty[num].second] = '.';  //填入的位置填入1，2，3，4，5，6，7，8，9都不行，则返回false
        return false;
    }
};