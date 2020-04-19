package G20200343040039

import (
	"math"
	"sort"
)

func leastInterval(tasks []byte, n int) int {
	cache := make([]int ,26)

	for _, char := range tasks {
		cache[char - 'A']++
	}

	sort.Ints(cache)

	maxValue := cache[25] - 1
	idleSlots := maxValue * n

	for i := 24; i >= 0 && cache[i] > 0; i-- {
		idleSlots -= int(math.Min(float64(cache[i]), float64(maxValue)))
	}

	if idleSlots > 0 {
		return idleSlots + len(tasks)
	}

	return len(tasks)
}