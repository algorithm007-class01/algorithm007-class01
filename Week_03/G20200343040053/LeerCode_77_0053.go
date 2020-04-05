package leetcode_week03_G20200343040053

//【77. 组合】

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法

//leetcode submit region begin(Prohibit modification and deletion)
func combine(n int, k int) [][]int {
	ret := make([][]int, 0)
	if n <= 0 || k <= 0 || n < k {
		return ret
	}
	stack := make([]int, 0)
	getCombinations(n, k, 1, 0, stack, &ret)
	return ret
}

func getCombinations(n, k, index, cnt int, stack []int, ret *[][]int) {
	if cnt == k {
		s := make([]int, len(stack))
		copy(s, stack)
		*ret = append(*ret, s)
		return
	}
	for i := index; i <= n-k+cnt+1; i++ {
		stack = append(stack, i)
		getCombinations(n, k, i+1, cnt+1, stack, ret)
		stack = stack[:len(stack)-1]
	}
}

//leetcode submit region end(Prohibit modification and deletion)
