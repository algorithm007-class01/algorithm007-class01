package myself;

import java.util.Arrays;

public class LeetCode_529_0201 {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }
//        if (board[x][y] == 'B') {
//            return;
//        }
        // 只管没有挖过的方块，挖过的以及是地雷的方块，都不管
        if (board[x][y] == 'E') {
            int count = 0;
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'M')
                        count++;
                }
            }
            // 如果四周有地雷，那么就将值置为数字，并返回
            if (count != 0) {
                board[x][y] = (char) ('0' + count);
                return;
            } else { // 如果四周没有地雷，那么就dfs递归下去
                board[x][y] = 'B';
                for (int nx = x - 1; nx <= x + 1; nx++) {
                    for (int ny = y - 1; ny <= y + 1; ny++) {
                        dfs(board, nx, ny);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] input = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        new LeetCode_529_0201().updateBoard(input, new int[]{3, 0});
        for (char[] item : input) {
            System.out.println(Arrays.toString(item));
        }
    }

}
