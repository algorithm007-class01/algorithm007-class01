package leetcode_week03_G20200343040053

//【46. 全排列】

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法

//leetcode submit region begin(Prohibit modification and deletion)
func permute(nums []int) [][]int {
	if len(nums) == 0 {
		return nil
	}

	ret := make([][]int, 0)
	backtrack(nums, nil, &ret)

	return ret
}

func backtrack(nums []int, prev []int, ret *[][]int) {
	if len(nums) == 0 {
		*ret = append(*ret, append([]int{}, prev...))
		return
	}

	for i := 0; i < len(nums); i++ {
		backtrack(append(append([]int{}, nums[0:i]...), nums[i+1:]...),
			append(prev, nums[i]),
			ret)
	}
}

//leetcode submit region end(Prohibit modification and deletion)
