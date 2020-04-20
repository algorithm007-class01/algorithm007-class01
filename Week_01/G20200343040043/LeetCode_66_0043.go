// 题目：https://leetcode-cn.com/problems/plus-one/
// 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
// 你可以假设除了整数 0 之外，这个整数不会以零开头



// 解法
// 进位，如果最后一位是9，要进位在前一位再次进行加一操作，特殊特殊情况为全9时，数组空间不足
package G20200343040043
func plusOne(digits []int) []int {
    for i := len(digits) - 1; i >= 0; i--{
        if digits[i] < 9 {
            digits[i]++
            return digits
        } else {
            digits[i] = 0
        }
    }
    return append([]int{1}, digits...)
}

// times: 1
