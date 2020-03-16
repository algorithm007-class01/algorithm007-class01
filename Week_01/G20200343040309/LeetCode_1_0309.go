package main

func TwoSum(nums []int, target int) []int {

	twosum := make(map[int]int)

	for index, value := range nums {
		twosum[value] = index
	}

	for index1, value1 := range nums {
		value2 := target - value1
		if index2, ok := twosum[value2]; ok && index1 != index2 {
			return []int{index1, index2}
		}
	}
	return nil
}
