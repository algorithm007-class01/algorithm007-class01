package G20200343040043

import "sort"

// 455. 分发饼干
// 题目：https://leetcode-cn.com/problems/assign-cookies/

// 解法
// 排序，然后分发

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	i, j := 0, 0
	for i < len(g) && j < len(s) {
		if g[i] <= s[j] {
			i++
		}
		j++
	}
	return i
}

// times: 1
