/*
 * @lc app=leetcode.cn id=283 lang=swift
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    // 解法一： 遍历数据 记录 0 的个数   将非 0 数据往前移动当前 0 的个数的位数
    // func moveZeroes(_ nums: inout [Int]) {
    //     let count = nums.count
    //     var zeroCount = 0
    //     for (index, item) in nums.enumerated() {
    //         if item == 0 {
    //             zeroCount += 1
    //         }else {
                //  赋值为零这步操作等同于和 0 互换位置
    //             nums[index] = 0
    //             let correntIndex = index - zeroCount
    //             nums[correntIndex] = item
                
    //         }
    //     }
    // }

    // 解法二： 双指针 快指针（遍历）判断是否为 0，慢指针（+1）指向最后一位为零的地址将两个指针数据互换
    // func moveZeroes(_ nums: inout [Int]) {
    //     var notZeroIndex = 0
    //     for (index, item) in nums.enumerated() {
    //         if item != 0 {
    //             (nums[notZeroIndex], nums[index]) = (nums[index], nums[notZeroIndex])
    //             notZeroIndex += 1
    //         }
    //     }
    // }

    //解法三： 双循环，将非 0 数据按顺序覆盖，再将最后剩余替换成 0
    func moveZeroes(_ nums: inout [Int]) {
        var notZeroIndex = 0
        for (index, item) in nums.enumerated() {
            if item != 0 {
                nums[notZeroIndex] = nums[index]
                notZeroIndex += 1
            }
        }
        for i in notZeroIndex..<nums.count {
            nums[i] = 0
        }
    }
}
// @lc code=end

