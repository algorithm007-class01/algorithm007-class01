package G20200343040043

// 题目：https://leetcode-cn.com/problems/trapping-rain-water/
// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 解法
// 体积大小由高度小的决定，因此记左右最大值以计算体积，根据当前左右高度从小向大逼近，同时不停更新两侧最大高度

func trap(height []int) int {
	volumes := 0
	leftMax, rightMax := 0, 0
	left, right := 0, len(height)-1
	for left < right {
		if height[left] < height[right] {
			if height[left] < leftMax {
				volumes += leftMax - height[left]
			} else {
				leftMax = height[left]
			}
			left++
		} else {
			if height[right] < rightMax {
				volumes += rightMax - height[right]
			} else {
				rightMax = height[right]
			}
			right--
		}

	}
	return volumes
}

// times: 1
