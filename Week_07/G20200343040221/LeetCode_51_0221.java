//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.*;

public class NQueens_51 {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final String Q = "Q";
    private final String N = ".";

    // DFS
    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            return Arrays.asList(Arrays.asList(Q));
        }
        if (n < 4) {
            return new ArrayList<>();
        }

        List<List<String>> r = new ArrayList<>();
        int[] settles = new int[n];
        for (int i = 0; i < n; i++) {
            settles[0] = i;
            dfs(1, n, settles, r);
        }
        return r;
    }

    private void dfs(int i, int n, int[] settles, List<List<String>> r) {
        if (i == n) {
            List<String> rows = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder str = new StringBuilder();
                int settle = settles[j];
                for (int k = 0; k < n; k++) {
                    str.append(k == settle ? Q : N);
                }
                rows.add(str.toString());
            }
            r.add(rows);
            return;
        }

        // 剪枝
        int[] set = new int[n];
        for (int j = 0; j < i; j++) {
            int settle = settles[j];
            set[settle] = -1;

            int offset = i - j;
            int left = settle - offset;
            if (left >= 0) {
                set[left] = -1;
            }

            int right = settle + offset;
            if (right < n) {
                set[right] = -1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (set[j] != -1) {
                settles[i] = j;
                dfs(i + 1, n, settles, r);
            }
        }

        settles[i] = 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  