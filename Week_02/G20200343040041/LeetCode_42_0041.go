package G20200343040041

//接雨水

//暴力
//水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值
//时间复杂度O(n^2),空间复杂度O(1)
func trap(height []int) int {
	sum, size := 0, len(height)
	for i := 0; i < size; i++ {
		maxLeft, maxRight := 0, 0
		for j := i; j >= 0; j-- {
			maxLeft = max(maxLeft, height[j])
		}

		for j := i; j < size; j++ {
			maxRight = max(maxRight, height[j])
		}
		sum += min(maxLeft, maxRight) - height[i]

	}
	return sum
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

//单调栈
//时间复杂度O(n),空间复杂度O(n)
func trapByStack(height []int) int {
	stack := make([]int, 0, len(height))
	sum, cur := 0, 0
	for cur < len(height) {
		for len(stack) > 0 && height[cur] > height[stack[len(stack)-1]] {
			//pop
			oldTop := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			if len(stack) == 0 {
				break
			}

			newTop := stack[len(stack)-1]
			width := cur - newTop - 1
			h := min(height[cur], height[newTop]) - height[oldTop]
			sum += width * h

		}
		stack = append(stack, cur)
		cur++
	}
	return sum
}

//TODO 动态规划

//双指针
