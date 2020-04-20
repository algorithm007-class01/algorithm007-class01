func rotate(nums []int, k int) {
	size := len(nums)
	var tempArray = make([]int, size)
	for index, _ := range nums {
		tempArray[(index + k) % size] = nums[index]
	}

	for index, _ := range tempArray {
		nums[index] = tempArray[index]
	}
}

func rotate1(nums []int, k int)  {
	size := len(nums)
	for k > 0 {
		lastValue := nums[size - 1]
		for index, _ := range nums {
			if index == size - 1 {
				continue
			}
			nums[size - index - 1] = nums[size - index - 2]
		}
		nums[0] = lastValue
		k--
	}
}
