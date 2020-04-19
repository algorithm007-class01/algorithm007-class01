//leetcode_289_0109.cpp
// 生命游戏

#include <iostream>
#include <vector>
#include <string>


//时间复杂度O(m*n)
void gameOfLife(std::vector<std::vector<int>>& board) 
{
    int rows = board.size();
    int cols = board[0].size();

    // 创建复制数组 copyBoard
    std::vector<std::vector<int> >copyBoard(rows, std::vector<int>(cols, 0));

    // 从原数组复制一份到 copyBoard 中
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            copyBoard[row][col] = board[row][col];
        }
    }

        // 遍历面板每一个格子里的细胞
    for (int row = 0; row < rows; row++) 
    {
        for (int col = 0; col < cols; col++) 
        {
            //copyBoard[row][col]附近的8个坐标
            int row1 = row - 1, col1 = col - 1;
            int row2 = row - 1, col2 = col;
            int row3 = row - 1, col3 = col + 1;

            int row4 = row, col4 = col - 1;
            int row5 = row, col5 = col + 1;

            int row6 = row + 1, col6 = col - 1;
            int row7 = row + 1, col7 = col;
            int row8 = row + 1, col8 = col + 1;

            //计算8个里面有几个活细胞
            int nLive = 0;
            if(row1 >= 0 && row1 < rows && col1 >= 0 && col1 < cols)
            {
                if(copyBoard[row1][col1])
                {
                    nLive++;
                }
            }
            if(row2 >= 0 && row2 < rows && col2 >= 0 && col2 < cols)
            {
                if(copyBoard[row2][col2])
                {
                    nLive++;
                }
            }
            if(row3 >= 0 && row3 < rows && col3 >= 0 && col3 < cols)
            {
                if(copyBoard[row3][col3])
                {
                    nLive++;
                } 
            }
            if(row4 >= 0 && row4 < rows && col4 >= 0 && col4 < cols)
            {
                if(copyBoard[row4][col4])
                {
                    nLive++;
                }
            }
            if(row5 >= 0 && row5 < rows && col5 >= 0 && col5 < cols)
            {
                if(copyBoard[row5][col5])
                {
                    nLive++;
                }
            }            
            if(row6 >= 0 && row6 < rows && col6 >= 0 && col6 < cols)
            {
                if(copyBoard[row6][col6])
                {
                    nLive++;
                }
            }
            if(row7 >= 0 && row7 < rows && col7 >= 0 && col7 < cols)
            {
                if(copyBoard[row7][col7])
                {
                    nLive++;
                }
            }
            if(row8 >= 0 && row8 < rows && col8 >= 0 && col8 < cols)
            {
                if(copyBoard[row8][col8])
                {
                    nLive++;
                }
            }
            // 规则 1 或规则 3      
            if ((copyBoard[row][col] == 1) && (nLive < 2 || nLive > 3)) {
                board[row][col] = 0;
            }
            // 规则 4
            if (copyBoard[row][col] == 0 && nLive == 3) {
                board[row][col] = 1;
            }
        }
        
    }

}

int main(void)
{
    
    char ar;
    std::cin>>ar;
    return 0;
}