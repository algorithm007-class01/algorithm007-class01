package G20200343040039

import "math"

func splitArray(nums []int, m int) int {
	n := len(nums)

	f := make([][]int, n + 1)
	for i := 0; i < n + 1; i++ {
		f[i] = make([]int, m + 1)
	}
	sub := make([]int, n + 1)

	for i := 0; i <= n; i++ {
		for j := 0; j <= m; j++ {
			f[i][j] = math.MaxInt32
		}
	}

	for i := 0; i < n; i++ {
		sub[i + 1] = sub[i] + nums[i]
	}

	f[0][0] = 0;

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			for k := 0; k < i; k++ {
				f[i][j] = int(math.Min(float64(f[i][j]), math.Max(float64(f[k][j - 1]), float64(sub[i] - sub[k]))))
			}
		}
	}
	return f[n][m];
}