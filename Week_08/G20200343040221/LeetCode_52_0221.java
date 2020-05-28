//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法

package leetcode.editor.cn;

// 52. N皇后 II
public class NQueensIi_52 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        if (n < 4) {
            return 0;
        }

        return dfs1(0, n, 0, 0, 0);
    }
    private int dfs1(int row, int n, int shu, int pie, int na) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int pieIndex = row + i;
            int naIndex = n - 1 - row + i;
            if (((shu >> i) & 1) == 0 && ((pie >> pieIndex) & 1) == 0 && ((na >> naIndex) & 1) == 0) {
                count += dfs1(row + 1, n, shu | (1 << i), pie | (1 << pieIndex), na | (1 << naIndex));
            }
        }
        return count;
    }

    // DFS
    public int totalNQueens1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n < 4) {
            return 0;
        }

        return dfs(0, n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }
    private int dfs(int row, int n, boolean[] shu, boolean[] pie, boolean[] na) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int pieIndex = row + i;
            int naIndex = n - 1 - row + i;
            if (shu[i] || pie[pieIndex] || na[naIndex]) {
                continue;
            }
            shu[i] = pie[pieIndex] = na[naIndex] = true;
            count += dfs(row + 1, n, shu, pie, na);
            shu[i] = pie[pieIndex] = na[naIndex] = false;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
