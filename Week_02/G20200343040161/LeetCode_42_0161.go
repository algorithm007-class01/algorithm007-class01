package G20200343040161

func trap(height []int) int {
	if height == nil || len(height) < 3 {
		return 0
	}
	sum := 0
	stack := make([]int, 0)
	n := len(height)
	for i := 0; i < n; i++ {
		// 当当前i元素height大于栈顶元素height值时，将栈顶元素弹出，并计算i元素height值和新栈顶元素height值之间的水面积
		for len(stack) != 0 && height[i] >height[stack[len(stack)-1]] {
			h := height[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]
			// 如果栈为空，则说明左边界兜不住水，直接break即可
			if len(stack) == 0 {
				break
			}
			// 如果新栈顶元素和原栈顶元素相同，则说明兜不住水，直接continue即可，直到找到下一个可以兜住水的左边界
			if height[stack[len(stack)-1]] == h {
				continue
			}

			distince := i - stack[len(stack)-1] - 1
			// 根据水桶原理，左右边界较低的那一边是装水的最大高度
			min := 0
			if height[stack[len(stack)-1]] < height[i] {
				min = height[stack[len(stack)-1]]
			} else {
				min = height[i]
			}

			sum += distince*(min - h)
		}
		// 若i元素heaght值小于栈顶元素，则说明可以放水，如栈即可
		stack = append(stack, i)
	}

	return sum
}