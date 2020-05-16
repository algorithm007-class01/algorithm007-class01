import java.util.Stack;

public class LeetCode_130_0201 {
    /**
     * 标识二维矩阵对应节点是否已经访问过了
     */
    boolean[][] visited;

    /**
     * 暂存被改为X的O位置。如果发现不满足条件时，取出来再改回O。
     * 可以使用其它数据结构存放，不过我这里想用Stack而已
     */
    Stack<String> stack;

    public void solve(char[][] board) {
        if (board.length == 0) return;
        visited = new boolean[board.length][board[0].length];
        stack = new Stack<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    dfs(board, i, j);
                    stack.clear();
                }
                visited[i][j] = true;
            }
        }
    }


    private boolean dfs(char[][] board, int i, int j) {
        /**
         * 如果发现有沾边界的O区域，将改为X的O位置取出，改回O
         */
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            while (!stack.isEmpty()) {
                String[] s = stack.pop().split(",");
                board[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 'O';
            }
            return false;
        }

        if (board[i][j] == 'O') {
            /**
             * 如果发现有未访问过的O，那么
             * 就将这个位置的O改为X
             * 并且对从这个位置开始向四面做DFS
             */
            if (!visited[i][j]) {
                visited[i][j] = true;
                board[i][j] = 'X';
                stack.push(i + "," + j);
                if (!dfs(board, i - 1, j)) return false; //上
                if (!dfs(board, i, j - 1)) return false; //左
                if (!dfs(board, i + 1, j)) return false; //下
                if (!dfs(board, i, j + 1)) return false; //右
            } else {
                /**
                 * 如果发现是一个访问过的O，说明这个O是处在一个沾边界的O区域的。
                 * 那么就回退回去。将改为X的O位置取出，改回O
                 */
                while (!stack.isEmpty()) {
                    String[] s = stack.pop().split(",");
                    board[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 'O';
                }
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        char[][] input = new char[][]{{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        char[][] input = new char[][]{{'O', 'O', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'O', 'O'}};
        new LeetCode_130_0201().solve(input);
    }

}