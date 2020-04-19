/*
 * @lc app=leetcode.cn id=860 lang=swift
 *
 * [860] 柠檬水找零
 */

// @lc code=start
// 第一遍的思路是利用数组，遇到 5 则回收，遇到 10 则判断数组是否有 5，遇到 20 则判断数组中是否满足一个 10 一个 5 后者三个五
// 在此发现最后一个判断中 10+5 或 5+5+5 的实现出现了问题。
// 第二篇看完题解。因为找零钱里会用到只有 5 或者 10，所以利用两个变量计数
// 贪心算法相关知识： 贪心 - 每次找到局部最优解 - 找回 15 先判断是否有 10
class Solution {
    func lemonadeChange(_ bills: [Int]) -> Bool {
        var five = 0
        var ten = 0

        for bill in bills {
            if bill == 5 {
                five += 1
            }else if bill == 10 {
                five -= 1
                ten += 1
            }else {
                if ten > 0 {
                    ten -= 1
                }else {
                    five -= 2
                }
                five -= 1
            }

            if five < 0{
                return false
            }

        }
        return five >= 0
    }
}
// @lc code=end

