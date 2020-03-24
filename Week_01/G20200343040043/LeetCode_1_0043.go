// 题目：https://leetcode-cn.com/problems/two-sum/
// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

// 解法
// hash存储遍历过的值，k为数组内的值，v为下标
// 存在则return
package G20200343040043
func twoSum(nums []int, target int) []int {
    catch := make(map[int]int)
    for idx, v := range nums{
        if target_idx, ok := catch[target - v]; ok {
            return []int{target_idx, idx}
        }
        catch[v]=idx
    }
    return nil
}

// times: 1
