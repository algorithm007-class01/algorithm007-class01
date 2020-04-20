func moveZeroes(nums []int)  {
    lastNonZero := 0
    for i := range nums {
        if nums[i] != 0 {
            nums[lastNonZero], nums[i] = nums[i], nums[lastNonZero]
            lastNonZero++
        }
    }
}
