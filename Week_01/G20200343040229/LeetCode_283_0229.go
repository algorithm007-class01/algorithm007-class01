func moveZeroes(nums []int)  {
	arraySize := len(nums)

	for i := 0; i < arraySize; i++ {
		for j := i + 1; j < arraySize; j++ {
			if nums[i] == 0 {
				tmp := nums[i]
				nums[i] = nums[j]
				nums[j] = tmp
			}
		}
	}
}
