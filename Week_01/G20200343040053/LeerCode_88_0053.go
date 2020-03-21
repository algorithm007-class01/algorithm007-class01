package leetcode_week01_G20200343040053

import "sort"

//【88. 合并两个有序数组】

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针

//leetcode submit region begin(Prohibit modification and deletion)
// 从大到小从后往前赋值
func merge(nums1 []int, m int, nums2 []int, n int) {
	// 一直循环到 nums2 放完位置
	for n > 0 {
		// 当 nums1 中 m 个元素已放完 或者 当前 nums2 最后一个元素大于等于 nums1 最后一个元素时
		if m == 0 || nums2[n-1] >= nums1[m-1] {
			nums1[m+n-1] = nums2[n-1]
			n--
		} else { // 当前 nums1 最后一个元素大于 nums2 最后一个元素
			nums1[m+n-1] = nums1[m-1]
			m--
		}
	}
}

//leetcode submit region end(Prohibit modification and deletion)

// 先合并后排序
func mergeSolution2(nums1 []int, m int, nums2 []int, n int) {
	nums1 = append(nums1[:m], nums2[:n]...)
	sort.Ints(nums1)
}
