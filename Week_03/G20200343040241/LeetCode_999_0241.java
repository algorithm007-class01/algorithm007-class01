public class LeetCode_641_0241 {

    /*在一个 8 x 8 的棋盘上，有一个白色的车（Rook），用字符 'R' 表示。棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），分别用字符 '.'，'B' 和 'p' 表示。不难看出，大写字符表示的是白棋，小写字符表示的是黑棋。

    车按国际象棋中的规则移动。东，西，南，北四个基本方向任选其一，然后一直向选定的方向移动，直到满足下列四个条件之一：

    棋手选择主动停下来。
    棋子因到达棋盘的边缘而停下。
    棋子移动到某一方格来捕获位于该方格上敌方（黑色）的卒，停在该方格内。
    车不能进入/越过已经放有其他友方棋子（白色的象）的方格，停在友方棋子前。
    你现在可以控制车移动一次，请你统计有多少敌方的卒处于你的捕获范围内（即，可以被一步捕获的棋子数）。
    */

    /**
     * mysolution
     */
    class Solution {
        public int numRookCaptures(char[][] board) {
            int count = 0;
            for(int i = 0;i < 8;i++){
                for(int j = 0;j<8;j++){
                    if(board[i][j] == 'R'){
                        //向上
                        for(int h = i;h>=0;h--){
                            if(board[h][j] == 'p'){
                                count++;
                                break;
                            }else if(board[h][j] == 'B'){
                                break;
                            }
                        }
                        //向下
                        for(int d = i;d<8;d++){
                            if(board[d][j] == 'p'){
                                count++;
                                break;
                            }else if(board[d][j] == 'B'){
                                break;
                            }
                        }
                        //向左
                        for(int l = j;l>=0;l--){
                            if(board[i][l] == 'p'){
                                count++;
                                break;
                            }else if(board[i][l] == 'B'){
                                break;
                            }
                        }
                        //向右
                        for(int r = j;r<8;r++){
                            if(board[i][r] == 'p'){
                                count++;
                                break;
                            }else if(board[i][r] == 'B'){
                                break;
                            }
                        }
                    }
                }
            }
            return count;
        }
    }

    /**
     * 优化  国际版大牛解法
     */
    class Solution {
        int cap(char[][] b, int x, int y, int dx, int dy) {
            while (x >= 0 && x < b.length && y >= 0 && y < b[x].length && b[x][y] != 'B') {
                if (b[x][y] == 'p') return 1;
                x += dx; y += dy;
            }
            return 0;
        }
        public int numRookCaptures(char[][] b) {
            for (int i = 0; i < b.length; ++i)
                for (int j = 0; j < b[i].length; ++j)
                    if (b[i][j] == 'R') return cap(b,i,j,0,1)+cap(b,i,j,0,-1)+cap(b,i,j,1,0)+cap(b,i,j,-1,0);
            return 0;
        }
    }
