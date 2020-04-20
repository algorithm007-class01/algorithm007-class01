package leetcode_week04_G20200343040053

//【153. 寻找旋转排序数组中的最小值】

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 你可以假设数组中不存在重复元素。
//
// 示例 1:
//
// 输入: [3,4,5,1,2]
//输出: 1
//
// 示例 2:
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0
// Related Topics 数组 二分查找

//leetcode submit region begin(Prohibit modification and deletion)
func findMin(nums []int) int {
	i, j := 0, len(nums)-1

	for i < j {
		mid := (j-i)/2 + i
		if nums[mid] < nums[0] {
			j = mid
		} else if nums[mid] > nums[j] {
			i = mid + 1
		} else {
			return nums[i]
		}
	}
	return nums[i]
}

//leetcode submit region end(Prohibit modification and deletion)
