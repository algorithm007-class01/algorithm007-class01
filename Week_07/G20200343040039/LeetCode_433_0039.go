package G20200343040039

func minMutation(start string, end string, bank []string) int {
	used := make([]int, len(bank))
	stack := []string{start}
	level := 0

	for len(stack) > 0 {
		level++
		levelCount := len(stack)

		for levelIndex := 0; levelIndex < levelCount; levelIndex++ {
			for index, element := range bank {
				if element != start && used[index] == 0 {
					diff := diffCount(stack[levelIndex], element)
					if diff == 1 {
						used[index] = level
						if element == end {
							return level
						}

						stack = append(stack, element)
					}
				}
			}
		}

		stack = stack[levelCount:]
	}

	return -1
}

func diffCount(levelStr string, element string) int {
	count := 0

	for i := 0; i < len(levelStr); i++ {
		if levelStr[i] != element[i] {
			count++
			if count >= 2 {
				return count
			}
		}
	}

	return count
}
