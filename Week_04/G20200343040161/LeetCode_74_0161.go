package G20200343040161

func searchMatrix(matrix [][]int, target int) bool {
	if matrix == nil {
		return false
	}

	m := len(matrix)
	if m == 0 {
		return false
	}
	n := len(matrix[0])
	left := 0
	right := m*n - 1

	for left <= right {
		mid := left + (right-left)/2
		tmp := matrix[mid/n][mid%n]
		if tmp == target {
			return true
		} else if tmp>target {
			right = mid-1
		} else {
			left = mid+1
		}
	}

	return false
}