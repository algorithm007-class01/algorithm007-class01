/*
 * @lc app=leetcode.cn id=26 lang=swift
 *
 * [26] 删除排序数组中的重复项
    1. 双指针，慢指针指向非重复项位置，快指针指向最新判断的数据
 */

// @lc code=start
// 解法一： 双指针，慢指针指向非重复的下标，快指针指向最新的元素
class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        if nums.count <= 1{
            return 1
        }

        var slow = 0
        for i in 1..<nums.count {
            if nums[slow] != nums[i] {
                slow += 1
                nums[slow] = nums[i]
            }
        }
        return slow+1
    }
}

// 解法二： 改进，当双指针不相邻时，即相邻是不重复时不发生赋值操作
class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        if nums.count <= 1{
            return nums.count
        }
        var slow = 0
        for i in 1..<nums.count {
            if nums[slow] != nums[i] {
                // improve 
                if i - slow > 1 {   
                    nums[slow + 1] = nums[i]
                }
                slow += 1
            }
        }
        return slow+1
    }
}

// 解法三： 对重复元素进行计数，count 表示的是共发生了多少次重复，【1，1，2，2，2】的 count 为 3
class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        if nums.count <= 1{
            return nums.count
        }
        var count = 0
        for i in 1..<nums.count {
            if nums[i] == nums[i-1] {
                count += 1
            }else{
                nums[i - count] = nums[i]
            }
        }
        return nums.count - count
    }
}
// @lc code=end

