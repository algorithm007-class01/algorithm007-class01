package leetcode_week07_G20200343040053

//【51. N皇后】

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
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ）
//
// Related Topics 回溯算法

//leetcode submit region begin(Prohibit modification and deletion)
func solveNQueens(n int) [][]string {
	var result [][]string

	t := make([][]rune, n)
	for i := range t {
		t[i] = make([]rune, n)
		for j := range t[i] {
			t[i][j] = '.'
		}
	}

	backtracking(&result, t, n, 0)
	return result
}
func backtracking(res *[][]string, c [][]rune, r, column int) {
	if r == 0 {
		var arr []string
		for _, v := range c {
			arr = append(arr, string(v))
		}
		*res = append(*res, arr)
		return
	}

	for i := 0; i < len(c); i++ {
		if !reject(c, i, column) {
			c[i][column] = 'Q'
			backtracking(res, c, r-1, column+1)
			c[i][column] = '.'
		}
	}
}
func reject(c [][]rune, row, col int) bool {
	for i := 0; i < col; i++ {
		if c[row][i] == 'Q' {
			return true
		}
	}

	for i, j := row, col; i >= 0 && j >= 0; {
		if c[i][j] == 'Q' {
			return true
		}
		i--
		j--
	}

	for i, j := row, col; i < len(c) && j >= 0; {
		if c[i][j] == 'Q' {
			return true
		}
		i++
		j--
	}
	return false
}

//leetcode submit region end(Prohibit modification and deletion)
