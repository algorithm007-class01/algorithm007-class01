package G20200343040039

import "math"

func maxSumSubmatrix(matrix [][]int, k int) int {
	if matrix == nil || len(matrix) == 0 {
		return 0
	}

	rows := len(matrix)
	cols := len(matrix[0])
	ans := math.MinInt32

	for left := 0; left < cols; left++ {
		rowSum := make([]int, rows)
		for rigtht := left; rigtht < cols; rigtht++  {
			for i := 0; i < rows; i++ {
				rowSum[i] += matrix[i][rigtht]
			}
			ans = int(math.Max(float64(ans), float64(maxSumSubMatrixHelper(rows, rowSum, k))))

			if ans == k {
				return k
			}
		}
	}

	return ans
}

func maxSumSubMatrixHelper(rows int, rowSum []int, k int) int {
	helperSum := rowSum[0]
	maxSum := helperSum

	for i := 1;i < rows; i++ {
		if helperSum <= 0 {
			helperSum = rowSum[i]
		} else {
			helperSum += rowSum[i]
		}

		if helperSum > maxSum {
			maxSum = helperSum
		}
	}

	if maxSum <= k {
		return maxSum
	}

	max := math.MinInt32

	for i := 0; i < rows; i++ {
		sum := 0
		for j := i; j < rows; j++ {
			sum += rowSum[j]

			if sum <= k && sum > max {
				max = sum
			}

			if max == k {
				return k
			}


		}
	}

	return max
}