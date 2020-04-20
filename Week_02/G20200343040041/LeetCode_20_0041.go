package G20200343040041

func isValid(s string) bool {
	if s == "" {
		return true
	}

	stack := make([]rune, 0, 1)

	th := map[rune]rune{
		'}': '{',
		')': '(',
		']': '[',
	}

	for _, v := range s {
		switch v {
		case '{', '[', '(':
			stack = append(stack, v)
		case '}', ']', ')':
			if len(stack) == 0 || stack[len(stack)-1] != th[v] {
				return false
			} else {
				stack = stack[:len(stack)-1]
			}
		}
	}

	return len(stack) == 0
}
