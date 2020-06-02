//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode.editor.cn;

public class SurroundedRegions_130 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final char X = 'X';
    private final char O = 'O';
    private final char Y = 'Y';

    private final int BOUNDARY_ROOT = -1;

    // 并查集
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        if (n == 0) {
            return;
        }

        int[] parents = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                parents[index] = isEdge(i, j, m, n) && board[i][j] == O ? BOUNDARY_ROOT : index;
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == O) {
                    if (board[i - 1][j] == O) {
                        union(i * n + j, (i - 1) * n + j, parents);
                    }
                    if (board[i + 1][j] == O) {
                        union(i * n + j, (i + 1) * n + j, parents);
                    }
                    if (board[i][j - 1] == O) {
                        union(i * n + j, i * n + (j - 1), parents);
                    }
                    if (board[i][j + 1] == O) {
                        union(i * n + j, i * n + (j + 1), parents);
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (find(i * n + j, parents) != BOUNDARY_ROOT) {
                    board[i][j] = X;
                }
            }
        }
    }

    private boolean isEdge(int i, int j, int m, int n) {
        return i == 0 || j == 0 || i == m - 1 || j == n - 1;
    }

    private int find(int p, int[] parents) {
        if (p == BOUNDARY_ROOT || parents[p] == p) {
            return p;
        }

        int root = find(parents[p], parents);
        parents[p] = root;
        return root;
    }

    private void union(int p, int q, int[] parents) {
        int rootP = find(p, parents);
        int rootQ = find(q, parents);
        if (rootP == rootQ) {
            return;
        }
        if (rootP == BOUNDARY_ROOT) {
            parents[rootQ] = BOUNDARY_ROOT;
        } else if (rootQ == BOUNDARY_ROOT) {
            parents[rootP] = BOUNDARY_ROOT;
        } else {
            parents[rootQ] = rootP;
        }
    }

    // 基于DFS
    public void solve1(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        if (n == 0) {
            return;
        }

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i, m, n);
            dfs(board, m - 1, i, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == O) {
                    board[i][j] = X;
                } else if (board[i][j] == Y) {
                    board[i][j] = O;
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != O) {
            return;
        }

        board[i][j] = Y;

        dfs(board, i + 1, j, m, n);
        dfs(board, i - 1, j, m, n);
        dfs(board, i, j + 1, m, n);
        dfs(board, i, j - 1, m, n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  