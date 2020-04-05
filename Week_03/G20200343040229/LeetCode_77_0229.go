func combine(n int, k int) [][]int {
	nums := []int{}
	for i := 1; i <= k; i++ {
		nums = append(nums, i)
	}
	nums = append(nums, n + 1)

	output, j := [][]int{}, 0
	for j < k {
		tmp := []int{}
		for _, value := range nums[:k] {
			tmp = append(tmp, value)
		}
		output = append(output, tmp)
		j = 0
		for j < k && nums[j + 1] == nums[j] + 1 {
			nums[j] = j + 1
			j++
		}
		nums[j] += 1
	}

	return output
}
