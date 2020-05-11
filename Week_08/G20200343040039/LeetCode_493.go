package G20200343040039

import (
	"math"
	"sort"
)

func reversePairs(nums []int) int {
	numsCopy := make([]int, len(nums))
	copy(numsCopy, nums)
	sort.Slice(numsCopy, func(i, j int) bool {
		return numsCopy[i] < numsCopy[j]
	})

	numsLen := len(nums)

	bits := make([]int, numsLen + 1)
	result := 0
	for i := 0; i < numsLen; i++ {
		index1 := b_sort(numsCopy, nums[i]*2 + 1)
		index2 := b_sort(numsCopy, nums[i])

		result += get(bits, index1 + 1)
		update(bits, index2 + 1, 1)
	}

	return result
}

func get(bits []int, index int) int {
	count := 0
	for index < len(bits) {
		count += bits[index]
		index += (index & - index)
	}

	return count
}

func update(bits []int, index int, value int) {
	for index > 0 {
		bits[index] += value
		index -= (index & -index)
	}
}

func b_sort(numsCopy []int, num int) int {
	l := 0
	r := len(numsCopy)

	for l < r {
		mid := int(math.Floor(float64((l + r) / 2)))
		if numsCopy[mid] < num {
			l = mid + 1
		} else if numsCopy[mid] > num {
			r = mid
		} else {
			return mid
		}
	}

	return l
}
