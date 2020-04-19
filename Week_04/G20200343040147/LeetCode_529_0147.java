import java.util.Arrays;

public class LeetCode_529_0147 {

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = click[0];
        int n = click[1];
        dfs(board, m, n);
        return board;

    }

    public void dfs(char[][] board, int x, int y) {
        int r = board.length;
        int c = board[0].length;
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return;
        }

        if (board[x][y] == 'E') {
            board[x][y] = 'B';
            int count = judge(board, x, y);
            if (count == 0) {
                for (int i = 0; i < 8; i++) {
                    dfs(board, x + dx[i], y + dy[i]);
                }
            } else {
                board[x][y] = (char) (count + '0');
            }
        } else if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }
    }

    // 获取当前借点相邻的地雷数量
    public int judge(char[][] board, int x, int y) {
        int r = board.length;
        int c = board[0].length;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= r || newY < 0 || newY >= c) {
                continue;
            }
            if (board[newX][newY] == 'M') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};

        char[][] r = new LeetCode_529_0147().updateBoard(board, click);
        for (int i = 0; i < r.length; i++) {
            System.out.println(Arrays.toString(r[i]));
        }
    }
}
