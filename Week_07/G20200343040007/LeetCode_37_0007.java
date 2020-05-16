//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<String> set = new HashSet<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                code(i, j, board[i][j]);
        dfs(0, board);
    }

    private void code(int i, int j, char[][] board) {
        String s = "(" + board[i][j] + ")";
        set.add(i + s);
        set.add(s + j);
        set.add(i / 3 + s + j / 3);
    }

    private boolean code(int i, int j, char c) {
        String s = "(" + c + ")";
        if (set.contains(i + s) || set.contains(s + j) || set.contains(i / 3 + s + j / 3))
            return false;
        set.add(i + s);
        set.add(s + j);
        set.add(i / 3 + s + j / 3);
        return true;
    }

    private void remove(int i, int j, char c) {
        String s = "(" + c + ")";
        set.remove(i + s);
        set.remove(s + j);
        set.remove(i / 3 + s + j / 3);
    }

    private boolean dfs(int level, char[][] b) {
        if (level == 81) return true;
        if (b[level / 9][level % 9] == '.') {
            for (int k = '1'; k <= '9'; ++k) {
                if (!code(level / 9, level % 9, (char) k))
                    continue;
                b[level / 9][level % 9] = (char) k;
                if (dfs(level + 1, b))
                    return true;
                else {
                    remove(level / 9, level % 9, (char) k);
                    b[level / 9][level % 9] = '.';
                }
            }
            return false;
        } else
            return dfs(level + 1, b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
