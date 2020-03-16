// 题目：https://leetcode-cn.com/problems/move-zeroes/
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
// 必须在原数组上操作，不能拷贝额外的数组。尽量减少操作次数。

// 解法
// 找到第一个0，0后面的第一个非0数做替换

func moveZeroes(nums []int)  {
    zero := 0
    for idx, value := range nums{
        if value != 0 {
            nums[zero], nums[idx] = nums[idx], nums[zero]
            zero++
        }
    }
}

// times: 1
