package G20200343040039

func generateParenthesis(n int) []string {
	result := make([]string, 0)

	recur("", 0, 0, n, &result)

	return result
}

func recur(cur string, left int, right int, n int, result *[]string) {
	if len(cur) == 2 * n {
		*result = append(*result, cur)
	}

	if left < n {
		recur(cur + "(", left + 1, right, n, result)
	}

	if right < left {
		recur(cur + ")", left, right + 1, n, result)
	}
}