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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> result = new ArrayList<>();
    int n;
    int[] solutions;
    int[] row;
    int[] pie;
    int[] na;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        solutions = new int[n];
        row = new int[n];
        pie = new int[2 * n - 1];
        na = new int[2 * n];
        backTracK(0);
        return result;
    }
    
    private void backTracK(int row) {
        for (int col = 0; col < n; ++col) {
            if (isAvaiable(row, col)) {
                addElement(row, col);
                
                if (row + 1 == n) addSolution();
                else backTracK(row + 1);
                
                removeElement(row, col);
            }
        }
    }
    
    private void addSolution() {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < solutions[row]; col++)
                sb.append(".");
            sb.append("Q");
            for (int col = solutions[row] + 1; col < n; col++)
                sb.append(".");
            list.add(sb.toString());
        }
        result.add(list);
    }
    
    private void removeElement(int row, int col) {
        this.row[col] = 0;
        pie[row + col] = 0;
        na[row - col + n] = 0;
    }
    
    private void addElement(int row, int col) {
        solutions[row] = col;
        this.row[col] = 1;
        pie[row + col] = 1;
        na[row - col + n] = 1;
    }
    
    private boolean isAvaiable(int row, int col) {
        int res = this.row[col] + pie[row + col] + na[row - col + n];
        return res == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
