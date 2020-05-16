package G20200343040039

func relativeSortArray(arr1 []int, arr2 []int) []int {
	counter := make([]int, 1001)
	for _, value := range arr1 {
		counter[value]++
	}
	index := 0

	for _, value := range arr2 {
		for counter[value] > 0 {
			arr1[index] = value
			index++
			counter[value]--
		}
	}

	for i := 0; i < len(counter); i++ {
		for counter[i] > 0 {
			arr1[index] = i
			counter[i]--
			index++
		}
	}

	return arr1
}
