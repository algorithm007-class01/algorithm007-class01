func relativeSortArray(arr1 []int, arr2 []int) []int {
    lastIdx := 0
	for i := 0; i < len(arr2); i++ {
		for j := lastIdx; j < len(arr1); j++ {
			if arr1[j] == arr2[i] {
				arr1[lastIdx], arr1[j] = arr1[j], arr1[lastIdx]
				lastIdx++
			}
		}
	}
	sort.Ints(arr1[lastIdx:])
	return arr1
}

