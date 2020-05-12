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
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        solve(n, 0, 0, 0, 0);
        return result;
    }

    private void solve(int n, int row, int col, int pie, int na) {
        if (row == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        int pos = (~(col | pie | na)) & ((1 << n) - 1);
        while (pos > 0) {
            int p = pos & (-pos);
            list.add(creatString(p, n));
            pos &= pos - 1;
            solve(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            list.remove(list.size() - 1);
        }
    }

    private String creatString(int p, int n) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while ((p = p >>> 1) > 0)
            index++;
        for (int i = 0; i < index; ++i)
            sb.append(".");
        sb.append("Q");
        for (int i = index + 1; i < n; ++i)
            sb.append(".");
        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
