package leetcode_week02_G20200343040053

//【42. 接雨水】

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针

//leetcode submit region begin(Prohibit modification and deletion)
func trap(height []int) int {
	left, right := 0, len(height)-1
	ret, maxleft, maxright := 0, 0, 0
	for left <= right {
		if height[left] <= height[right] {
			if height[left] >= maxleft {
				maxleft = height[left]
			} else {
				ret += maxleft - height[left]
			}
			left++
		} else {
			if height[right] >= maxright {
				maxright = height[right]
			} else {
				ret += maxright - height[right]
			}
			right--
		}
	}
	return ret
}

//leetcode submit region end(Prohibit modification and deletion)
