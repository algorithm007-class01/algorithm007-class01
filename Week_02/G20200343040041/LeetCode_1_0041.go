package G20200343040041

func twoSum(nums []int, target int) []int {
	cache := make(map[int]int)
	for i, num := range nums {
		t := target - num
		if j, ok := cache[t]; ok {
			return []int{j, i}
		}
		cache[num] = i
	}
	return []int{}
}
