// 题目：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
// 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。


// 解法
// 遍历数组,找到第一个重复值，用下一个新值覆盖
// 存在则return
package G20200343040043
func removeDuplicates(nums []int) int {
    if len(nums) == 0{
        return 0
    }
    duplicates_idx := 0
    for idx, _ := range nums{
        if idx == 0 { 
            continue
            }
        if nums[idx] != nums[duplicates_idx] {
            duplicates_idx += 1 
            if duplicates_idx != idx{
                nums[duplicates_idx] = nums[idx]
            } 
        }       
    }
    return duplicates_idx + 1

}

// times: 1
