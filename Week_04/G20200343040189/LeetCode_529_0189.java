//让我们一起来玩扫雷游戏！
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）
//地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
//
//
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。
// 注意：
// 输入矩阵的宽和高的范围为 [1,50]。
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
// Related Topics 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 相邻位置
    //  x-1,y-1  x-1,y    x-1,y+1
    //  x,y-1    x,y      x,y+1
    //  x+1,y-1  x+1,y    x+1,y+1
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        // 行
        int r = board.length;
        // 列
        int c = board[0].length;
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return ;
        }
        if (board[x][y] == 'E') {
            // 如果当前为E，才进行判断是否要递归相邻结点
            board[x][y] = 'B';
            int count = judge(board, x, y);
            if (count == 0) {
                // 如果为0，则进行递归
                for (int i = 0; i < 8; i++) {
                    dfs(board, x + dx[i], y + dy[i]);
                }
            } else {
                // 如果不为0，则更新当前结点的值为地雷数量
                board[x][y] = (char) (count + '0');
            }
        } else if (board[x][y] == 'M') {
            // 这里不能用else，否则会递归修改掉已经是数字的位置
            board[x][y] = 'X';
        }
    }

    // 获取当前结点相邻的地雷数量
    private int judge(char[][] board, int x, int y) {
        int r = board.length;
        int c = board[0].length;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= r || newY< 0 || newY >= c) {
                continue;
            }
            if (board[newX][newY] == 'M') {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
