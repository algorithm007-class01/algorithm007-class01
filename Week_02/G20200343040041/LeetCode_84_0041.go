package G20200343040041

//柱状图中最大的矩形
//暴力求解
func largestRectangleArea(heights []int) int {
	if len(heights) == 0 {
		return 0
	}
	maxArea := 0
	for i := 0; i < len(heights); i++ {
		left, right := i, i
		for left >= 0 && heights[left] >= heights[i] {
			left--
		}

		for right < len(heights) && heights[right] >= heights[i] {
			right++
		}

		maxArea = max(maxArea, heights[i]*(right-left-1))
	}
	return maxArea
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
