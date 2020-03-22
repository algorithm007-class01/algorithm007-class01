func rotate(nums []int, k int)  {
    numsLen := len(nums)
    k = k % numsLen
    reverse(nums, 0, numsLen-1)
    reverse(nums, 0, k-1)
    reverse(nums, k, numsLen-1)
}

func reverse(nums []int, start, end int) {
    for start < end {
        nums[start], nums[end] = nums[end], nums[start]
        start++
        end--
    }
}
