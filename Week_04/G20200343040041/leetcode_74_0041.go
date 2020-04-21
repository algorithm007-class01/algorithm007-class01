package G20200343040041

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}

	lo, hi := 0, len(matrix)-1
	for lo <= hi {
		mid := lo + (hi-lo)>>1
		n := len(matrix[mid]) - 1
		if target < matrix[mid][0] {
			hi = mid - 1
		} else if target > matrix[mid][n] {
			lo = mid + 1
		} else {
			lo1, hi1 := 0, n
			for lo1 <= hi1 {
				mid1 := lo1 + (hi1-lo1)>>1
				if target == matrix[mid][mid1] {
					return true
				} else if target > matrix[mid][mid1] {
					lo1 = mid1 + 1
				} else {
					hi1 = mid1 - 1
				}
			}
			return false
		}
	}
	return false
}
