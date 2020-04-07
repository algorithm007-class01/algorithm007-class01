package G20200343040039

import "sort"

func findContentChildren(g []int, s []int) int {

	sort.Slice(g , func(i, j int) bool {
		return g[i] < g[j]
	})

	sort.Slice(s , func(i, j int) bool {
		return s[i] < s[j]
	})

	result := 0
	for j := 0; result < len(g) && j < len(s); {
		if g[result] <= s[j] {
			result++
		}
		j++
	}

	return result
}