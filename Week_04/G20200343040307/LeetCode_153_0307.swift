/*
 * @lc app=leetcode.cn id=153 lang=swift
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
// 暴力求解：因为是升序，所以遍历前者大于后者
// 二分法 mid > left left = mid + 1
class Solution {
    func findMin(_ nums: [Int]) -> Int {
        var left = 0 
        var right = nums.count - 1
        while left < right {
            let mid = left + (right - left) / 2
            // 等于的时候 就是 left + 1 = right 
			//  满足条件说明 mid 是前递增区间的较大值，其余情况改变有边界
            if nums[mid] >= nums[left] && nums[mid] > nums[right] {
                left = mid + 1
            }else {
                // 不减一，因为包含了等于的情况
                right = mid
            }
        }
        return nums[right]
    }
}
// @lc code=end

