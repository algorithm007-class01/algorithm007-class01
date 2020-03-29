package G20200343040039

func combine(n int, k int) [][]int {
	if k > n {
		return nil
	}
	result := make([][]int, 0)

	combine_rec(1, n, k, []int{}, &result)

	return result
}
// 12 13 14
func combine_rec(start, n int, k int, subResult []int,result *[][]int) {
	if len(subResult) == k {
		newSubResult := make([]int, 0)
		newSubResult = append(newSubResult, subResult...)
		*result = append(*result, newSubResult)
		return
	}

	for i := start; i <= n; i++ {
		subResult = append(subResult, i)

		combine_rec(i+1, n, k, subResult, result)

		subResult = subResult[:len(subResult)-1]
	}
}