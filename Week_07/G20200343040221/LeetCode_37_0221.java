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

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver_37 {

//    public static void main(String[] args) {
//        Solution solution = new SudokuSolver_37().new Solution();
//        System.out.println(solution);
//    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final int LEN = 9;
    private final char BLANK = '.';
    private final char ONE = '1';

    public void solveSudoku(char[][] board) {
        // 行、列、子九宫格已出现的数字的缓存
        // 第一维：
        //     [0,9): 行的缓存
        //     [9,18): 列的缓存
        //     [18,26]: 子九宫格的缓存
        // 第二维：数字是否已经出现
        boolean[][] cache = new boolean[LEN * 3][LEN];
        List<int[]> blanks = new ArrayList<>();
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                char ch = board[i][j];
                if (ch == BLANK) {
                    blanks.add(new int[] { i, j });
                } else {
                    int num = ch - ONE;
                    cache[i][num] = true;
                    cache[j + LEN][num] = true;
                    cache[(i / 3) * 3 + (j / 3) + LEN * 2][num] = true;
                }
            }
        }

        dfs(board, cache, 0, blanks);
    }
    private boolean dfs(char[][] board, boolean[][] cache, int index, List<int[]> blanks) {
        if (index == blanks.size()) {
            return true;
        }

        int[] pos = blanks.get(index);
        int i = pos[0];
        int j = pos[1];
        int rowIndex = i;
        int colIndex = j + LEN;
        int sdkIndex = (i / 3) * 3 + (j / 3) + LEN * 2;
        for (int k = 0; k < LEN; k++) {
            if (!cache[rowIndex][k] && !cache[colIndex][k] && !cache[sdkIndex][k]) {
                board[i][j] = (char)(k + ONE);
                cache[rowIndex][k] = cache[colIndex][k] = cache[sdkIndex][k] = true;

                if (dfs(board, cache, index + 1, blanks)) {
                    return true;
                }

                board[i][j] = BLANK;
                cache[rowIndex][k] = cache[colIndex][k] = cache[sdkIndex][k] = false;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  