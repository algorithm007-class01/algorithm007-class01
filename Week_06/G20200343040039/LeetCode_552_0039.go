package G20200343040039

func checkRecord(n int) int {
	M := 1000000007
	var f []int
	if n <= 5 {
		f = make([]int, 6)
	} else {
		f = make([]int, n + 1)
	}

	f[0] = 1
	f[1] = 2
	f[2] = 4
	f[3] = 7

	for i := 4; i <= n; i++ {
		f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M
	}

	sum := f[n]

	for i := 1; i <= n; i++ {
		sum += (f[i - 1] * f[n - i]) % M;
	}

	return (int)(sum % M);
}