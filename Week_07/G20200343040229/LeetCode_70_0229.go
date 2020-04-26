func climbStairsDriver(n int, sumArray []int) int {
	if sumArray[n] == -1 {
		sumArray[n] = climbStairsDriver(n - 1, sumArray) + climbStairsDriver(n - 2, sumArray)
	}

	return sumArray[n]
}

func climbStairs(n int) int {
    var sumArray []int
	sumArray = append(sumArray, 1)
	sumArray = append(sumArray, 2)
	for i := 2; i < n; i ++ {
		sumArray = append(sumArray, -1)
	}

	return climbStairsDriver(n - 1, sumArray)
}

