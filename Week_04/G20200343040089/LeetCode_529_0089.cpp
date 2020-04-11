/**
* Summary:minesweeper
* Parameters:
*   board: checkerboard vector
*	click: click coordinates
* Return: checkerboard after conversion
*/
class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        queue<pair<int, int>> q;
        vector<vector<int>> dir = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        int m = board.size(), n = board[0].size();
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        q.push(make_pair(click[0],click[1]));
        while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            if (board[x][y] == 'E') {
                int count = 0;
                for (int i = 0; i < 8; ++i) {
                    int x_next = x + dir[i][0];
                    int y_next = y + dir[i][1];
                    if (x_next < 0 || x_next >= m || y_next < 0 || y_next >= n) continue;
                    if (board[x_next][y_next] == 'M') count++;
                }
                if (count > 0) {
                    board[x][y] = '0' + count;
                } else {
                    board[x][y] ='B';
                    for (int i = 0; i < 8; ++i) {
                        int x_next = x + dir[i][0];
                        int y_next = y + dir[i][1];
                        if (x_next < 0 || x_next >= m || y_next < 0 || y_next >= n) continue;
                        if (board[x_next][y_next] == 'E') q.push(make_pair(x_next, y_next));
                    }
                }
            }
        }
        return board;
    }
};