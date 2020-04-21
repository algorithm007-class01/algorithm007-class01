package G20200343040041

import "sort"

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	num, j := 0, 0
	for i := 0; i < len(g); i++ {
		for ; j < len(s); j++ {
			if g[i] <= s[j] {
				num++
				j++
				break
			}
		}
	}
	return num
}
