package leetcode_week04_G20200343040053

//【45. 跳跃游戏 II】

//给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 示例:
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 说明:
//
// 假设你总是可以到达数组的最后一个位置。
// Related Topics 贪心算法 数组

//leetcode submit region begin(Prohibit modification and deletion)
func jump(nums []int) int {
	if len(nums) <= 1 {
		return 0
	}

	var maxIdx, i, step int
	for i < len(nums)-1 {
		nextIdx, tmpIdx := 0, 0
		for j := 0; j < nums[i]; j++ {
			tmpIdx = i + j + 1
			if tmpIdx < len(nums) && tmpIdx+nums[tmpIdx] > maxIdx {
				maxIdx = tmpIdx + nums[tmpIdx]
				nextIdx = tmpIdx
			}
			if tmpIdx == len(nums)-1 {
				nextIdx = tmpIdx
			}
		}
		i = nextIdx
		step++
	}
	return step
}

//leetcode submit region end(Prohibit modification and deletion)
