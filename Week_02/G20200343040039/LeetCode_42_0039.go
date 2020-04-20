package G20200343040039

func trap_bl(height []int) int {
	sum := 0

	for i := 1; i < len(height)-1; i++ {
		maxL := 0
		for j := i; j >= 0; j-- {
			if height[j] > maxL {
				maxL = height[j]
			}
		}

		maxR := 0
		for j := i; j < len(height); j++ {
			if height[j] > maxR {
				maxR = height[j]
			}
		}
		min := min(maxL, maxR)
		if min > height[i] {
			sum += min-height[i]
		}
	}

	return sum
}

func min(l int, r int) int {
	if l < r {
		return l
	}

	return r
}

func trap_dynamic(height []int) int {
	sum := 0
	maxLeft := make([]int, len(height))
	maxRight := make([]int, len(height))

	for i := 1; i < len(height)-1; i++ {
		maxLeft[i] = max(height[i-1], maxLeft[i-1])
	}

	for i := len(height)-2; i >= 0; i-- {
		maxRight[i] = max(height[i+1], maxRight[i+1])
	}

	for i := 1; i < len(height) - 1; i++ {
		minH := min(maxLeft[i], maxRight[i])
		if minH > height[i] {
			sum += minH - height[i]
		}
	}

	return sum
}

func max(h1 int, h2 int) int {
	if h1 > h2 {
		return h1
	}

	return h2
}

func trap_double_pointer(height []int) int {
	sum := 0
	left := 1
	right := len(height) - 2
	maxLeft := 0
	maxRight := 0

	for i := 1; i < len(height) - 1; i++ {
		if height[left-1] < height[right+1] {
			maxLeft = max(height[left-1], maxLeft)
			min := maxLeft
			if min > height[left] {
				sum += min - height[left]
			}

			left++
		} else {
			maxRight = max(height[right+1], maxRight)
			min := maxRight
			if min > height[right] {
				sum += min - height[right]
			}
			right--
		}
	}

	return sum
}

func trap_stack(height []int) int {
	sum := 0
	stack := make([]int, 0)

	for current := 0; current < len(height); current++ {
		for len(stack) != 0 && height[current] > height[stack[len(stack) - 1]] {
			h := height[stack[len(stack) - 1]] //保留栈里面最小的高度，然后，用当前高度和最小高度的前一个高度的最小高度，减去出栈的高度，计算水量的高度
			stack = stack[:len(stack) - 1]
			if len(stack) == 0 {
				break
			}
			distance := current - stack[len(stack) - 1] - 1
			minH := min(height[current], height[stack[len(stack) - 1]])
			if minH > h {
				sum += distance * (minH - h)
			}
		}
		stack = append(stack, current)
	}

	return sum
}

func trap_stack_1(height []int) int {
	sum := 0

	stack := make([]int, 0)

	for current := 0; current < len(height); current++ {
		for len(stack) != 0 && height[current] > height[stack[len(stack) - 1]] {
			curH := height[stack[len(stack) - 1]]
			stack = stack[:len(stack)-1]
			if len(stack) == 0 {
				break
			}

			distance := current - stack[len(stack) - 1] - 1
			minH := min(height[current], height[stack[len(stack) - 1]])
			if minH > curH {
				sum += distance * (minH - curH)
			}
		}
		stack = append(stack, current)
	}

	return sum
}