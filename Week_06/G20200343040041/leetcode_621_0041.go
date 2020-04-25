package G20200343040041

import "sort"

func leastInterval(tasks []byte, n int) int {
	if n == 0 {
		return len(tasks)
	}
	hash := make(map[byte]int)
	for _, v:= range tasks {
		hash[v] += 1
	}
	var sorted []int
	for _, v := range hash {
		sorted = append(sorted, v)
	}
	sort.Ints(sorted)

	count, end := 0, len(sorted)-1
	for i := end; i >=0 ; i-- {
		if sorted[i] == sorted[end] {
			count++
		}
	}
	sum := (sorted[end]-1) * (n+1) + count
	if sum < len(tasks) {
		sum = len(tasks)
	}
	return sum
}
